## Deprecated
SharedPref is deprecated in favor of [Jetpack DataStore](https://developer.android.com/topic/libraries/architecture/datastore).

---

SharedPref
==========
An android library for making [SharedPreferences](https://developer.android.com/reference/android/content/SharedPreferences.html) simple and easy!

# Download
### Gradle
```
implementation 'com.hitanshudhawan:shared-pref:1.0.0'
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
Default file ```name``` will be ```packageName``` of your project.
<br>
Default operating ```mode``` will be ```MODE_PRIVATE```.
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
<b>and that's it!</b> No need for ```commit()``` or ```apply()```.

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
