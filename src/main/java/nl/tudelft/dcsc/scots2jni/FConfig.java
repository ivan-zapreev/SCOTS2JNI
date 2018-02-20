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

/**
 * Stores configuration for the control fitness evaluator
 *
 * @author Dr. Ivan S. Zapreev
 */
public class FConfig {

    //The state-space size
    public final int m_ss_size;
    //The fitness type
    public final int m_ftn_type;
    //The atractor size [0,0.5)
    public final double m_attr_size;
    //The fitness function scaling factor for firness types such as INERSE and ARCTANG
    public final double m_ftn_scale;
    //True if the function shall be scaled to the min/max values befor fitness is computed
    public final boolean m_is_scale;
    //True if the fitness type with attractor is to be used, otherwise exact
    public final boolean m_is_complex;

    /**
     * The basic constructor 
     * 
     * @param ss_size state-space size
     * @param ftn_type fitness type
     * @param attr_size the attractor size
     * @param ftn_scale the fitness function scaling factor for fitness types such as INERSE and ARCTANG
     * @param is_scale true if the function is to be scaled first
     * @param is_complex true if the fitness type with attractor is to be used
     */
    public FConfig(final int ss_size, final int ftn_type,
            final double attr_size, final double ftn_scale,
            final boolean is_scale, final boolean is_complex) {
        this.m_ss_size = ss_size;
        this.m_ftn_type = ftn_type;
        this.m_attr_size = attr_size;
        this.m_ftn_scale = ftn_scale;
        this.m_is_scale = is_scale;
        this.m_is_complex = is_complex;
    }

}
