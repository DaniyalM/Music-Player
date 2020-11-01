package com.example.design.ui.viewmodels

import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat.METADATA_KEY_MEDIA_ID
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.design.data.entities.Song
import com.example.design.exoplayer.MusicServiceConnection
import com.example.design.exoplayer.isPlayEnabled
import com.example.design.exoplayer.isPlaying
import com.example.design.exoplayer.isPrepared
import com.example.design.other.Constants.MEDIA_ROOT_ID
import com.example.design.other.Resource

class MainViewModel @ViewModelInject constructor(
    private val musicServiceConnection: MusicServiceConnection
) :ViewModel(){
    private val _mediaItems = MutableLiveData<Resource<List<Song>>>()
    val mediaItems: LiveData<Resource<List<Song>>> = _mediaItems

    val isConnected=musicServiceConnection.isConnected
    val networkError=musicServiceConnection.networkError
    val curPlayingSong=musicServiceConnection.curPlayingSong
    val playBackState=musicServiceConnection.playbackState

    init {
        _mediaItems.postValue(Resource.loading(null))
        musicServiceConnection.subscribe(MEDIA_ROOT_ID,object :MediaBrowserCompat.SubscriptionCallback(){
            override fun onChildrenLoaded(
                parentId: String,
                children: MutableList<MediaBrowserCompat.MediaItem>
            ) {
               val items=children.map{
                   Song(
                       it.mediaId!!,
                       it.description.title.toString(),
                       it.description.subtitle.toString(),
                       it.description.mediaUri.toString(),
                       it.description.iconUri.toString()
                   )
               }

                _mediaItems.postValue(Resource.success(items))
            }
        })
    }

    fun skipToNextSong(){
        musicServiceConnection.transportControls.skipToNext()
    }
    fun skipToPreviousSong(){
        musicServiceConnection.transportControls.skipToNext()
    }

    fun seekTo(pos:Long){
        musicServiceConnection.transportControls
            .seekTo(pos)
    }

    fun playOrToggleSong(mediaItemId:Song,toggle:Boolean=false){
        val isPrepared=playBackState.value?.isPrepared ?: false

        if (isPrepared&&mediaItemId.mediaId== curPlayingSong.value?.getString(METADATA_KEY_MEDIA_ID)){
            playBackState.value?.let {playBackState->
                when{
                    playBackState.isPlaying->if (toggle)musicServiceConnection.transportControls.pause()
                    playBackState.isPlayEnabled->musicServiceConnection.transportControls.play()
                    else -> Unit
                }
            }
        }
        else{
            musicServiceConnection.transportControls.playFromMediaId(mediaItemId.mediaId,null)
        }
    }


    override fun onCleared() {
        super.onCleared()

        musicServiceConnection.unsubscribe(MEDIA_ROOT_ID,object :MediaBrowserCompat.SubscriptionCallback(){})
    }

}