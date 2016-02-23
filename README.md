# jupyter-kernel-jsr223

This project is a Java implementation of the Jupyter messaging protocol, suited
for JVM languages which implement the JSR223 ScriptEngine specification. For
those languages it provides an alternative to Jupyter kernel wrappers written
and tty-style communication.

## Rationale

My original motivation was to build a Jython kernel for Jupyter, which could
reliably handle I/O, including streams and which supported all the MIME types
Jupyter can display in its ouput cells. An already existing kernel wrapper for
Jython using a tty interface had I/O issues, in particular it scrambled input
from stdin with output from stdout. Since the kernel wrapper looked
inscrutable and its author already took some countermeasures which, after all,
didn't capture many relevant use cases, I decided for another approach, which
drops the Jupyter-to-terminal communication entirely. Instead the kernel should

   * implement the Jupyter messaging protocol 5.0
   * use JSR223 ScriptEngines for language abstraction
   * provide a kernel for Jython out of the box






