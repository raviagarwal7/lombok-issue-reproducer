`testToBuilder` & `testBuilder` fails with lombok version 1.18.34 but passes with lombok version 1.18.26
This is due to the change in https://github.com/projectlombok/lombok/commit/f13750c271accf72bcdb69a67795233aa99931e3#diff-e77c1ee806dc76859f179e046d7234e563a1c28c0b6f6955bb40be935dc68beeR1639

Specifically these two lines
```
			String annotationTypeName = getTypeName(ann.annotationType);
			for (String nn : NONNULL_ANNOTATIONS) if (typeMatches(nn, node, annotationTypeName)) return true;
```


```
╰─ ./gradlew test

> Task :test FAILED

SimplePojoTest > testToBuilder() FAILED
    java.lang.NullPointerException at SimplePojoTest.java:37

SimplePojoTest > testBuilder() FAILED
    java.lang.NullPointerException at SimplePojoTest.java:30

4 tests completed, 2 failed

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':test'.
> There were failing tests. See the report at: file:///Users/ravi/Uber/lombok-issue-reproducer/build/reports/tests/test/index.html

* Try:
> Run with --scan to get full insights.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.5/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD FAILED in 807ms
3 actionable tasks: 1 executed, 2 up-to-date
```
