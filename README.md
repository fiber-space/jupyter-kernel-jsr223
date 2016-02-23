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
drops the Jupyter-to-terminal communication entirely. 

The new kernel should

   * handle the Jupyter messaging protocol
   * use JSR223 ScriptEngines for JVM languages as an abstraction layer
   * provide at least a working kernel for Jython out of the box

Later I also added a kernel for Clojure.

## Getting started

### Building the project

After having cloned this project repository, switch to the project directory and build the project 
with ant

	~/home/my/repo/to/jupyter-kernel-jsr223 $ ant

If ant complaints with an exception and the message

 	org.apache.tools.ant.taskdefs.optional.junit.JUnitTask was not found	

you have to add an `ant-optional` dependency to ant. E.g. on Ubuntu you install 

	$ sudo apt-get install ant-optional 	

The project directory should now contain a `dist` folder showing the following content 
( modulo changes in version numbers ):

	dist
	├── javadoc
	├── jupyter-kernel-jsr223.jar
	├── lib
	│   ├── commons-cli-1.2.jar
	│   ├── jeromq-0.3.6.jar
	│   └── json.jar
	└── README.TXT

### Installing kernels and kernel specs

Since jupyter-kernel-jsr223 couples to language implementations only through jsr223 interfaces
the project is light on dependencies. In reverse this also means one has to install language interpreters
separately and add their paths in the kernelspec file `kernel.json`. A template for such a file can
be found at:


	kernelspec
	├── kernel.json
	└── README

Please open the README for further information.

After the classpath and the options have been properly set, create a new directory e.g.

	   home
	    └── my
			└── jython_kernel
			    └── kernel.json

For kernel installation type

	$ jupyter kernelspec install /home/my/jython_kernel

Finally control the kernel installation with	

	$ jupyter kernelspec list

## Using the kernel 

The jupyter-kernel-jsr223 library has been tested only with the Jupyter notebook and I don't intend to support
any other way to access it in the near future. If your installation worked correctly you can now launch your 
Jupyter notebook and should see something like the following image when you want to create a new notebook

![jupyter-kernel-selection](https://github.com/fiber-space/jupyter-kernel-jsr223/blob/master/doc/static/Jupyter-kernel-selection.png)