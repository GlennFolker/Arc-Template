package tmp.core;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;

import static arc.Core.*;

public class Renderer implements ApplicationListener{
    @Override
    public void update(){
        graphics.clear(Color.black);

        camera.width = graphics.getWidth();
        camera.height = graphics.getHeight();
        camera.update();

        Draw.reset();
        Draw.proj(camera);

        Draw.sort(true);

        // Do rendering jobs here...
        Draw.rect(atlas.find("frog"), Mathf.cos(Time.time, 10f, 24f), Mathf.sin(Time.time, 10f, 24f));

        Draw.reset();
        Draw.flush();
        Draw.sort(false);
    }
}
