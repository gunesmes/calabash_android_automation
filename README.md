# Prerequisite for developping Calabash and Cucumber

Make sure you have Ruby 1.9 or above installed (Ruby 2.0+ recommended).

Install bundler unless you already have it installed:

    gem install bundler

(or sudo gem install bundler)


Install gems in the `Gemfile`:

    bundle install


# To run Calabash for Android

To run the Android tests, ensure a recent Android SDK is installed, and that

* environment variable `ANDROID_HOME` is set to point to the sdk folder, such as:

* For fish shell
```shell
set ANDROID_HOME $HOME/Android/sdk/
set PATH $HOME/Android/sdk/tools $PATH
set PATH $HOME/Android/sdk/platform-tools $PATH
set JAVA_HOME /Library/Java/JavaVirtualMachines/1.8.0_20-b26/Contents/Home/bin/java
````

# Runing Calabash

Pull the repository and go into the project in the same folder where feature files stored and run one of the following command:

  * Running if there is one devices for (abd devices)
    
  `calabash-android run sampleAndroidProjectToAutomate.apk`
 
  * Running on a specific device
```shell
~ adb devices 
List of devices attached
0646944421157e89	device
emulator-5554	offline
```


    `calabash-android run sampleAndroidProjectToAutomate.apk ADB_DEVICE_ARG=0646944421157e89`
    
  * Running on a specific devices for specific test cases which are tag as **t**:

    `calabash-android run sampleAndroidProjectToAutomate.apk ADB_DEVICE_ARG=0646944421157e89 --tag @t`

![alt tag](https://lh4.googleusercontent.com/-HAj7-3bHsdA/VBaXlF3I5YI/AAAAAAAAB2I/gkEKwVEEYlc/w1005-h712-no/calabash_cucumber_android_test_result.png)
