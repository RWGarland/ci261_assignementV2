package com.allsopg.game.Sound;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.IntMap;

/**
 * Created by rg425 on 16/01/2018.
 */

public class SoundLink {
    private IntMap<Sound> soundKeys;

    public SoundLink(){
        soundKeys = new IntMap<Sound>();

        Sound waterDropSnd = Gdx.audio.newSound(Gdx.files.internal("sfx/WaterDrop.wav"));


        soundKeys.put(1,waterDropSnd);
    }

    public boolean play(int keyCode){
        Sound sound = soundKeys.get(keyCode);
        if(sound != null) {
            sound.play();
            return true;
        }
        return false;
    }

    public void dispose(){
        for(Sound sound : soundKeys.values()){
            sound.dispose();
        }
    }

}
