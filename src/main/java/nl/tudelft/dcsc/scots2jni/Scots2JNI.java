/* 
 * Copyright (C) 2018 Dr. Ivan S. Zapreev <ivan.zapreev@gmail.com>
 *
 *  Visit my Linked-in profile:
 *     https://nl.linkedin.com/in/zapreevis
 *  Visit my GitHub:
 *     https://github.com/ivan-zapreev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.tudelft.dcsc.scots2jni;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.tudelft.dcsc.sr2jlib.fitness.Fitness;

/**
 * This class represents the JNI interface for SCOTSv2.0 require to load the
 * original controller and to measure the fitness of provided individuals with
 * respect to it.
 *
 * @author <a href="mailto:ivan.zapreev@gmail.com"> Dr. Ivan S. Zapreev </a>
 */
public class Scots2JNI {

    //Stores the reference to the logger
    private static final Logger LOGGER = Logger.getLogger(Scots2JNI.class.getName());

    /**
     * Allows to load the library implementing the native methods
     *
     * @param lib_file_name the library file name
     * @throws UnsatisfiedLinkError is thrown when linking fails
     */
    public static void load_lib(final String lib_file_name) throws UnsatisfiedLinkError {
        LOGGER.log(Level.INFO, "Loading the SCOTS2DLL dynamic library:"
                + " {0}, library path: {1}", new Object[]{lib_file_name,
                    System.getProperty("java.library.path")});
        System.load(lib_file_name);
    }

    /**
     * Allows to load the controller
     *
     * @param file_name the file name to load the controller form
     * @return the number of controller dimensions
     * @throws java.io.FileNotFoundException
     */
    public static native int load(final String file_name)
            throws FileNotFoundException;

    /**
     * Allows to get the controller's state space size. I.e. the number of
     * state-space grid points. This value is larger than the domain size.
     *
     * @param ss_dim the number of state-space dimensions
     *
     * @return the loaded controller's state-space size.
     */
    public static native int get_state_space_size(final int ss_dim)
            throws IllegalStateException;

    /**
     * Allows to configure the fitness computer
     *
     * @param cfg the configuration class
     * @throws IllegalStateException if the controller is not loaded
     */
    public static native void configure(final FConfig cfg)
            throws IllegalArgumentException;

    /**
     * Allows to compute the fitness value for the individual defined by the
     * class name
     *
     * @param class_name the class name storing the generated function
     * @return the fitness value of the generated function
     * @throws IllegalStateException if the controller is not loaded
     * @throws java.lang.ClassNotFoundException if the individual class could
     * not be found
     */
    public static native Fitness compute_fitness(
            final String class_name)
            throws IllegalStateException, IllegalArgumentException,
            ClassNotFoundException;

    /**
     * Allows to start the new export of the unfit points for the symbolic
     * controller into a BDD.
     */
    public static native void start_unfit_export();

    /**
     * Allows to export the unfit points of the given individual into the BDD.
     *
     * @param class_name the individual's class name
     * @return the real (actual) fitness of the individual
     */
    public static native double export_unfit_points(
            final String class_name);

    /**
     * Allows to finish the new export of the unfit points for the symbolic
     * controller into a BDD.
     *
     * @param file_name the file name, without extension to export the points
     */
    public static native void finish_unfit_export(
            final String file_name);

}
