package net.outmoded.skanada.sandbox_physics_area_manager;

import com.jme3.bullet.PhysicsSpace;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.joml.Vector2i;

import java.util.HashMap;
import java.util.Map;

public class SandBox {
    private final Map<Vector2i, String> chunks = new HashMap<>();
    private PhysicsSpace physicsSpace;
    final Vector2i start;
    final Vector2i end;
    final String name;

    protected SandBox(String name ,Vector2i start, Vector2i end){
        this.name = name;
        this.start = start;
        this.end = end;

        physicsSpace = new PhysicsSpace(PhysicsSpace.BroadphaseType.DBVT);

        for (int x = start.x; x >= end.x; x++) { // will not work if start is larger than end

            for (int z = start.y; z >= end.y; z++) {
                chunks.put(new Vector2i(x, z), "collision"); // construct collision for chunk
            }
        }

        // combine
    }

    public void close(){
        //physicsSpace.get


    }

}
