# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\ide\android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
# 指定代码的压缩级别
#-optimizationpasses 5

# 混淆时是否记录日志
-verbose
-dontpreverify # 不预校验
-dontoptimize #不优化输入的类文件
-dontshrink #该选项 表示 不启用压缩

-dontusemixedcaseclassnames # 混淆时不会产生形形色色的类名
-dontskipnonpubliclibraryclasses #不跳过(混淆) jars中的 非public classes   默认选项

#-dontwarn # 去掉警告
#-dontskipnonpubliclibraryclassmembers #不跳过 jars中的非public classes的members

# 优化
#-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#-allowaccessmodification #优化时允许访问并修改有修饰符的类和类的成员
#-renamesourcefileattribute SourceFile
#-keepattributes SourceFile,LineNumberTable
#-repackageclasses ''

-keepclassmembers class **.R$* {
    public static <fields>;
}

-keepattributes Exceptions,InnerClasses,...
#过滤泛型
-keepattributes Signature
#过滤注解
-keepattributes *Annotation*
#过滤js
-keepattributes *javascriptinterface*

# 保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# 保持自定义控件类不被混淆
#-keepclasseswithmembers class * {
#    public <init>(android.content.Context, android.util.AttributeSet);
#}

#-keepclasseswithmembers class * {
#    public <init>(android.content.Context, android.util.AttributeSet, int);
#}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}


 # 保持枚举 enum 类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#-keep public class * {
#    public protected *;
#}

-keep public class * implements java.io.Serializable {
        public *;
}

-keepclassmembers class * implements java.io.Serializable {
    static final long serialversionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}


-keep class sun.misc.Unsafe { *; }


-dontwarn com.amap.api.**
-dontwarn com.a.a.**
-dontwarn com.autonavi.**

-dontwarn org.apache.http.**
-dontwarn com.fasterxml.jackson.databind.**

-dontwarn  com.Google.zxing.client.android.**
-dontwarn  com.tencent.weibo.sdk.android.**
-dontwarn  com.bbk.secureunisignon.**
-dontwarn  com.qiniu.android.**
-dontwarn  com.umeng.socialize.**
-dontwarn  net.sf.json.**
-dontwarn  org.eclipse.paho.**
-dontwarn  org.eclipse.paho.client.mqttv3.**

-keep org.eclipse.paho.** {*;}
-keep org.eclipse.paho.client.mqttv3.** {*;}

-keep class com.amap.api.** {*;}
-keep class com.autonavi.**  {*;}
-keep class com.a.a.**  {*;}

-keep class android.support.** {*;}
-keep class org.** {*;}
-keep class com.fasterxml.jackson.core.** {*;}
-keep interface com.fasterxml.jackson.core { *; }
-keep public class * extends com.fasterxml.jackson.core.**
-keep class com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std.<clinit>
-keep class com.fasterxml.jackson.databind.ObjectMapper.<clinit>
-keep class com.fasterxml.jackson.databind.** {*;}
-keep class com.fasterxml.jackson.databind.introspect.VisibilityChecker$*{*;}
-keep interface com.fasterxml.jackson.databind { *; }
-keep public class * extends com.fasterxml.jackson.databind.**
-keep class net.sf.json.** {*;}
-keep class com.qiniu.android.** {*;}
-keep class com.bbk.secureunisignon.** {*;}
-keep class com.tencent.weibo.sdk.android.** {*;}
-keep class com.umeng.socialize.** {*;}
-keep class com.google.zxing.client.android.** {*;}
-keep class com.j256.ormlite.** {*;}
-keep class com.org.simple.eventbus.**{*;}

-keep class com.android.**{*;}
#-assumenosideeffects class_specification



# 下面两条为EventBus
-keepclassmembers class ** {
    public void onEvent*(**);
}

# Only required if you use AsyncExecutor
-keepclassmembers class * extends de.greenrobot.event.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

# for squareup picasso
-dontwarn com.squareup.okhttp.**

# for butterknife
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepnames class * { @butterknife.InjectView *;}


#所有jackson对应实体类不能混淆
-keep class com.oyp.model.** {*;}


##友盟推送混淆
-dontwarn com.umeng.message.proguard.**

#-dontwarn com.ut.mini.**
-dontwarn okio.**
#-dontwarn com.xiaomi.**
#-dontwarn com.squareup.wire.**
#-dontwarn android.support.v4.**
#
#-keepattributes *Annotation*
#
#-keep class android.support.v4.** { *; }
#-keep interface android.support.v4.app.** { *; }
#
-keep class okio.** {*;}
#-keep class com.squareup.wire.** {*;}
#
#-keep class com.umeng.message.protobuffer.* {
#    public <fields>;
#     public <methods>;
#}
#
#-keep class com.umeng.message.* {
#    public <fields>;
#     public <methods>;
#}
#
#-keep class org.android.agoo.impl.* {
#    public <fields>;
#     public <methods>;
#}
#
#-keep class org.android.agoo.service.* {*;}
#
#-keep class org.android.spdy.**{*;}
#
#-keep public class com.oyp.R$*{
#    public static final int *;
#}