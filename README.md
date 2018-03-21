[![Hitanshu Dhawan](https://img.shields.io/badge/Hitanshu-Dhawan-blue.svg)](https://github.com/hitanshu-dhawan)
[![Open Source Love png2](https://badges.frapsoft.com/os/v2/open-source.png?v=103)](https://github.com/hitanshu-dhawan/SharedPref)
[![License](https://img.shields.io/badge/License-Apache--2.0-green.svg)](https://github.com/hitanshu-dhawan/SharedPref/blob/master/LICENSE)

SharedPref
==========
An android library for making [SharedPreferences](https://developer.android.com/reference/android/content/SharedPreferences.html) simple and easy!

# Download
### Gradle
```
implementation 'com.hitanshudhawan:shared-pref:1.0.0'
```
### Maven
```
<dependency>
  <groupId>com.hitanshudhawan</groupId>
  <artifactId>shared-pref</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

# Usage
### Initialize
```
SharedPref sharedPref = new SharedPref(context);
// or
SharedPref sharedPref = new SharedPref(context, name);
// or
SharedPref sharedPref = new SharedPref(context, name, mode);
```
Default file ```name``` will be packageName of your project.
<br>
Default operating ```mode``` will be MODE_PRIVATE.
### Put
```
sharedPref.putString(key, value);
sharedPref.putInt(key, value);
sharedPref.putLong(key, value);
// and many more...
```
### Get
```
sharedPref.getString(key, defValue);
sharedPref.getInt(key, defValue);
sharedPref.getLong(key, defValue);
// and many more...
```

# Licence
```
Copyright (c) 2018 Hitanshu Dhawan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
