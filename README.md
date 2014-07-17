PLA(PinterestLikeAdapterView)
==================================

基于[PinterestLikeAdapterView](https://github.com/huewu/PinterestLikeAdapterView)开源项目的瀑布流控件。

------

由于公司项目的需要，我将对此Fork做有限的维护，包括：

1. 跟进 Android SDK API 版本
2. 跟进 Android Studio 的 Gradle 开发环境和编译环境
3. 修复发现的Bug。

Usage
--------

如果你只是想使用这个库，可以使用我推送到Sonatype仓库的版本，按如下操作：

在根目录的 `build.gradle` 里添加：

	allprojects {
	    repositories {
	        mavenLocal()
	        mavenCentral()
			// !!!! ADD THIS !!!
	        maven{ url 'https://oss.sonatype.org/content/groups/public' }
	    }
	}

在依赖中添加：

	dependencies {
	    compile fileTree(dir: 'libs', include: ['*.jar'])

	    compile 'com.github.chenyoca:plav:1.0@aar'
	}



界面截图
----------------
![Screenshot](https://raw.github.com/chenyoca/pinterest-like-adapter-view/master/screenshot_1.png)
![Screenshot](https://raw.github.com/chenyoca/pinterest-like-adapter-view/master/screenshot_2.png)
![Screenshot](https://raw.github.com/chenyoca/pinterest-like-adapter-view/master/screenshot_3.png)
![Screenshot](https://raw.github.com/chenyoca/pinterest-like-adapter-view/master/screenshot_4.png)

说明
-------------
 **非原创项目**，基于[PinterestLikeAdapterView](https://github.com/huewu/PinterestLikeAdapterView)开源项目的瀑布流控件。

 * 1、修正[PinterestLikeAdapterView](https://github.com/huewu/PinterestLikeAdapterView)下拉刷新的Bug。
 * 2、添加到列表底部自动添加更多数据的接口：setLoadMoreListener(...)
 

特性
-----------
 * **纯组件** 像原生ListView一样使用。
  
 * 自定义瀑布流列数

 * 支持到列表底部自动加载更多数据

 * 支持下拉刷新：MultiColumnPullToRefreshListView


## License

    Copyright 2012 huewu.yang
    Copyright 2012 chenyoca

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
