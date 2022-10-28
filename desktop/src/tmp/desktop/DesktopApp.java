package tmp.desktop;

import arc.Files.*;
import arc.backend.sdl.*;
import arc.util.*;
import tmp.*;

import static arc.backend.sdl.jni.SDL.*;

public class DesktopApp{
    public static void main(String[] args){
        try{
            new SdlApplication(new Template(), new SdlConfig(){{
                title = "Arc Template Project";

                setWindowIcon(FileType.internal, "icon.png");
            }});
        }catch(Throwable err){
            Log.err(Strings.neatError(Strings.getFinalCause(err)));
            SDL_ShowSimpleMessageBox(SDL_MESSAGEBOX_ERROR, "Crash!", Strings.getFinalMessage(err));
        }
    }
}
