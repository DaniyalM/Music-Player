package com.example.design.exoplayer.callbacks

import android.widget.Toast
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.Player
import com.example.design.exoplayer.MusicService

class MusicPlayerEventListener(
  private val musicService: MusicService
) : Player.EventListener {

  override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
    super.onPlayerStateChanged(playWhenReady, playbackState)
    if(playbackState == Player.STATE_READY && !playWhenReady) {
      musicService.stopForeground(false)
    }
  }

  override fun onPlayerError(error: ExoPlaybackException) {
    super.onPlayerError(error)
    Toast.makeText(musicService, "An unknown error occured", Toast.LENGTH_LONG).show()
  }
}
