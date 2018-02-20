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
 * @author Dr. Ivan S. Zapreev
 */
public class Scots2JNI {

    static {
        //ToDo: Avoid this explicit dependency by using a property file of smth
        final String libName = "/Users/izapreev/Projects/CCLR/soft/SCOTS2DLL/dist/libSCOTS2DLL.dylib";
        try {
            System.load(libName);
        } catch (UnsatisfiedLinkError ex) {
            Logger.getLogger(Scots2JNI.class.getName()).log(Level.SEVERE,
                    "Native code library '" + libName + "' failed to load.\n", ex);
            System.exit(1);
        }
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
     * Allows to configure the fitness computer
     *
     * @param cfg the configuration class
     */
    public static native void configure(final FConfig cfg)
            throws IllegalArgumentException;

    /**
     * Allows to compute the fitness value for the individual defined by the
     * class name
     *
     * @param class_name the class name storing the generated function
     * @param dof_idx the input space dof index
     * @return the fitness value of the generated function
     * @throws IllegalStateException
     * @throws java.lang.ClassNotFoundException
     */
    public static native Fitness compute_fitness(
            final String class_name, final int dof_idx)
            throws IllegalStateException, IllegalArgumentException,
            ClassNotFoundException;
}
