## README

The kernel.json file in this directory is a template for Jupyter kernel specs
set up according to

    http://jupyter-client.readthedocs.org/en/latest/kernels.html#kernel-specs

In order to have a valid kernel spec you need to replace the sigilled $VARIABLEs
with appropriate values.

### Jython example

An example of a kernel spec for Jython with paths from my own development machine is
Note that the special {connection_file} is a Jupyter variable which is filled by Jupyter when it calls
the kernel. No need to touch it.

    {
     "argv": ["java",
              "-classpath",

                  "/opt/jython2.7.0/jython.jar:/opt/jupyter-kernel-jsr223/jupyter-kernel-jsr223.jar",
                  "/opt/jython2.7.0/jython.jar:/home/kay/NetBeansProjects/jupyter-kernel/dist/jupyter-kernel.jar",
              "org.jupyterkernel.kernel.Session",
                  "-k", "python",
                  "-f", "{connection_file}"],
     "display_name": "Jython 2.7",
     "language": "python"
    }

    
    
### Jython example for Windows
Note that the special {connection_file} is a Jupyter variable which is filled by Jupyter when it calls
the kernel. No need to touch it.
    {
      "argv": ["java",
        "-classpath",
        "C:\\jython2.7.0\\jython.jar;C:\\git\\jupyter-kernel-jsr223\\dist\\jupyter-kernel-jsr223.jar;C:\\git\\jupyter-kernel-jsr223\\lib\\jeromq-0.3.6.jar;C:\\git\\jupyter-kernel-jsr223\\lib\\commons-cli-1.2.jar;C:\\git\\jupyter-kernel-jsr223\\lib\\json.jar",
        "org.jupyterkernel.kernel.Session",
        "-k", "python",
        "-f", "{connection_file}"],
      "display_name": "Jython 2.7",
      "language": "python"
    }


### Clojure example

Unlike Jython, Clojure 1.8.0 doesn't support jsr223 out of the box. Instead one needs a 3rd party implementation.

I can recommend the following one

    https://github.com/ato/clojure-jsr223

which I used for debugging. Unlike another implementation by the same author it
properly supports customization of Stdout.

Note that both the clojure-xxx.jar as well as the clojure-jsr223-xxx.jar have to be added to the classpath:

    {
     "argv": ["java",
              "-classpath",
                  "/opt/clojure-1.8.0/clojure-jsr223-1.8.0.jar:/opt/clojure-1.8.0/clojure-1.8.0.jar:/opt/jupyter-kernel-jsr223/jupyter-kernel-jsr223.jar",
              "org.jupyterkernel.kernel.Session",
                  "-k", "clojure",
                  "-f", "{connection_file}"],
     "display_name": "Clojure 1.8",
     "language": "clojure"
    }

