package net.outmoded.skanada;


import electrostatic4j.snaploader.LibraryInfo;
import electrostatic4j.snaploader.LoadingCriterion;
import electrostatic4j.snaploader.NativeBinaryLoader;
import electrostatic4j.snaploader.filesystem.DirectoryPath;
import electrostatic4j.snaploader.platform.NativeDynamicLibrary;
import electrostatic4j.snaploader.platform.util.NativeVariant;
import electrostatic4j.snaploader.platform.util.PlatformPredicate;

// this class loads the platform specific version of jme using JSnapLoader
public class JmeLoader {


    public static void registerLibrary(){


        // stolen from jme docs - https://stephengold.github.io/Libbulletjme/lbj-en/English/add.html
        LibraryInfo info = new LibraryInfo(null, "bulletjme", DirectoryPath.USER_DIR);
        NativeBinaryLoader loader = new NativeBinaryLoader(info);

        NativeDynamicLibrary[] libraries = {
                new NativeDynamicLibrary("native/linux/arm64", PlatformPredicate.LINUX_ARM_64),
                new NativeDynamicLibrary("native/linux/arm32", PlatformPredicate.LINUX_ARM_32),
                new NativeDynamicLibrary("native/linux/x86_64", PlatformPredicate.LINUX_X86_64),
                new NativeDynamicLibrary("native/osx/arm64", PlatformPredicate.MACOS_ARM_64),
                new NativeDynamicLibrary("native/osx/x86_64", PlatformPredicate.MACOS_X86_64),
                new NativeDynamicLibrary("native/windows/x86_64", PlatformPredicate.WIN_X86_64)
        };

        loader.registerNativeLibraries(libraries).initPlatformLibrary();
        printDetails(loader);
        try {
            loader.loadLibrary(LoadingCriterion.CLEAN_EXTRACTION);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Skanada.getInstance().getLogger().info("Loaded Jme 22.0.1 Successfully");


    }
    // stolen from JSnapLoader examples and modified to use the bukkit logger
    public static void printDetails(NativeBinaryLoader loader) {
        Skanada.getInstance().getLogger().info("--------------------------------------------------------------");
        Skanada.getInstance().getLogger().info("OS: " + NativeVariant.OS_NAME.getProperty());
        Skanada.getInstance().getLogger().info("ARCH: " + NativeVariant.OS_ARCH.getProperty());
        Skanada.getInstance().getLogger().info("VM: " + NativeVariant.JVM.getProperty());
        Skanada.getInstance().getLogger().info("--------------------------------------------------------------");
        Skanada.getInstance().getLogger().info("Jar Path: " + loader.getNativeDynamicLibrary().getJarPath());
        Skanada.getInstance().getLogger().info("Library Directory: " + loader.getNativeDynamicLibrary().getPlatformDirectory());
        Skanada.getInstance().getLogger().info("Compressed library path: " + loader.getNativeDynamicLibrary().getCompressedLibrary());
        Skanada.getInstance().getLogger().info("Extracted library absolute path: " + loader.getNativeDynamicLibrary().getExtractedLibrary());
        Skanada.getInstance().getLogger().info("Is Extracted: " + loader.getNativeDynamicLibrary().isExtracted());
        Skanada.getInstance().getLogger().info("--------------------------------------------------------------");
    }


}
