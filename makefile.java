JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        Minic.java \
        Token.java \
        AnalizadorSintactico.java \
        sym.java \
        AnalizadorLexico.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class