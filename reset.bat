cd C:\Users\Vivasva\AppData\Roaming\JetBrains\IntelliJIdea2020.2*
rmdir "eval" /s /q
del "options\other.xml"
reg delete "HKEY_CURRENT_USER\Software\JavaSoft\Prefs\jetbrains\idea" /f