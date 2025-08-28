package net.outmoded.skanada.sandbox_physics_area_manager;


import com.fasterxml.jackson.databind.JsonNode;
import org.bukkit.Location;
import org.joml.Vector2i;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// experimental efficient physics space system.
public final class SandboxManager { // this manages ALL sandboxes
    private static SandboxManager sandboxManager;

    private final Map<String, SandBox> sandboxRegister = new HashMap<>();

    private SandboxManager(){


    }

    public static SandboxManager getInstance() {
        if (sandboxManager == null) {
            sandboxManager = new SandboxManager();
        }
        return sandboxManager;
    }

    public void createSandbox(String name, Location location, Vector2i start, Vector2i end){
        if (sandboxRegister.containsKey(name)){
            return;
        }
        SandBox sandBox = new SandBox(name, start, end);
        sandboxRegister.put(name, sandBox);

    }

    public boolean hasSandbox(String name){
        return sandboxRegister.containsKey(name);

    }

    public SandBox getSandbox(String name){
        if (!sandboxRegister.containsKey(name)){
            return null;
        }

        return sandboxRegister.get(name);
    }

    public void removeSandbox(String name){
        if (!sandboxRegister.containsKey(name)){
            return;
        }

        sandboxRegister.get(name).close();
        sandboxRegister.remove(name);

    }

}
