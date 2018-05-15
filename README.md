# **JNI interface for `SCOTS2SR`**

**Author:** [Dr. Ivan S. Zapreev](https://nl.linkedin.com/in/zapreevis)

**Project pages:** [Git-Hub-Project](https://github.com/ivan-zapreev/SCOTS2JNI)

## **Introduction**

This software is a JNI interface for the `SCOTS2DLL` back-end (<https://github.com/ivan-zapreev/SCOTS2DLL>) of the `SCOTS2SR` (<https://github.com/ivan-zapreev/SCOTS2SR>) tool. The latter is used for generating functional representations of `SCOTSv2.0` (<https://gitlab.lrz.de/matthias/SCOTSv0.2>) BDD controllers.

## **Dependencies**

This project is dependent on:

1. Java Symbolic Regression Library - `SR2JLIB` (<https://github.com/ivan-zapreev/SR2JLIB>)

## **Required tools**

In order to build the project one requires to have:

1. Netbeans version 8.2 or later in its version containing: Java/JDK and C++
2. Java version 1.8 or later
3. C++ version 11 or later
3. GNU Compiler Collection (GCC/G++) 5.5.0 or later
4. XCode SDK with c++ version 4.2.1 or later (on Max OS X)

## **Build instructions**

Before the project can be build `SR2JLIB` is to be downloaded and build in the folders next the the folder containing this project.

The directory structure is assumed to be as follows:

```
$ ls -al
drwxr-xr-x  10 user  staff   320 May 15 10:22 .
drwxr-xr-x   8 user  staff   256 Feb 20 08:41 ..
drwxr-xr-x  12 user  staff   384 May 15 15:36 SR2JLIB
drwxr-xr-x   8 user  staff   256 May  7 12:12 SCOTS2JNI
```
Where `SCOTS2JNI` is storing this project. Further one needs to:

1. Build `SR2JLIB` following the instructions in <https://github.com/ivan-zapreev/SR2JLIB>

Further one requires to

1. Open the `SCOTS2JNI` project in Netbeans
3. Run project `build` from the Netbeans IDE

## **Resulting binary**

Building the project results in:

1. Java classes located in `./target/classes/` that will be used by the `SCOTS2SR` (<https://github.com/ivan-zapreev/SCOTS2SR>) tool
2. C/C++ header file `./target/jni/nl_tudelft_dcsc_scots2jni_Scots2JNI.h` that will be included from the `SCOTS2DLL` back-end (<https://github.com/ivan-zapreev/SCOTS2DLL>) project