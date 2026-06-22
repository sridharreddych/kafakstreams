# Fix IntelliJ JDK Configuration Error

## Error Message
```
java: JDK isn't specified for module 'consumer'
```

## Solutions

### Quick Fix (Recommended)

**Step 1: Open Project Structure**
- Press `Ctrl+Alt+Shift+S` (or go to **File** → **Project Structure**)

**Step 2: Set Project SDK**
- In the left sidebar, click **Project**
- Under **SDK**, click the dropdown
- Select **jdk-25.0.2** (or jdk-17+ that you have installed)
- If you don't see it, click **Add SDK** → **Add JDK** and browse to:
  - `C:\Program Files\Java\jdk-25.0.2` (or your Java installation path)

**Step 3: Apply Changes**
- Click **Apply** → **OK**

**Step 4: Rebuild Project**
- Go to **Build** → **Rebuild Project** (or press `Ctrl+F9`)
- Wait for the build to complete

---

### Alternative: Configure Module Directly

If the above doesn't work:

1. Open **File** → **Project Structure** (`Ctrl+Alt+Shift+S`)
2. In left sidebar, click **Modules**
3. Select **consumer** module
4. Click the **Dependencies** tab
5. In **Module SDK** dropdown, select **jdk-25.0.2**
6. Click **Apply** → **OK**
7. Rebuild project

---

### If JDK is Not Listed

1. Open **File** → **Project Structure**
2. Click **Project** in left sidebar
3. Under **SDK**, click the dropdown
4. Select **Add SDK** → **Add JDK**
5. Browse to Java installation folder:
   - `C:\Program Files\Java\jdk-25.0.2`
   - Or `C:\Program Files\Java\jdk-17` (if you have Java 17)
6. Click **OK**
7. Now select the newly added JDK
8. Click **Apply** → **OK**

---

### Verify It's Fixed

After applying the changes:
- The error should disappear
- **Build** → **Rebuild Project** should complete without errors
- In **Project Structure**, the SDK should be visible for both Project and consumer module

---

## What Changed in POM Files

Added explicit Java version properties to both `pom.xml` files:

```xml
<properties>
    <java.version>17</java.version>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
```

This helps both Maven and IntelliJ understand which Java version to use for compilation.

---

## Build Status After Fix
✅ Both `consumer` and `producer` modules compile successfully with Java 17
✅ All dependencies are resolved correctly
✅ Ready to run both applications

