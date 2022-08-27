module squareroothelp {
    opens com.main;
    exports com.faps to javafx.graphics;
    exports com.uicomponents;
    requires transitive javafx.controls;
}
