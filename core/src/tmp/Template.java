package tmp;

import arc.*;
import arc.assets.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import tmp.core.*;

import static arc.Core.*;

public class Template extends ApplicationCore{
    public static Logic logic;
    public static Renderer renderer;

    private boolean finished;

    @Override
    public void setup(){
        atlas = TextureAtlas.blankAtlas();
        batch = new SortedSpriteBatch();
        camera = new Camera();
        assets = new AssetManager();

        add(logic = new Logic());
        add(renderer = new Renderer());

        // No, 'aatls' is not a typo. It's just the way it is.
        assets.load("sprites/sprites.aatls", TextureAtlas.class).loaded = a -> {
            atlas.dispose();
            atlas = a;
        };
    }

    @Override
    public void update(){
        if(finished || (finished = assets.update())){
            super.update();
        }
    }
}
