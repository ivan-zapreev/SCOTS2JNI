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
 * @author <a href="mailto:ivan.zapreev@gmail.com"> Dr. Ivan S. Zapreev </a>
 */
public class FConfig {

    //The state-space size
    public final int m_ss_size;
    //The fitness type
    public final int m_ftn_type;
    //The atractor size [0,0.5) for firness types such as INERSE and ARCTANG
    public final double m_attr_size;
    //The fitness function scaling factor for firness types such as INERSE and ARCTANG
    public final double m_ftn_scale;
    //True if the function shall be scaled to the min/max values befor fitness is computed
    public final boolean m_is_scale;
    //True if the fitness type with attractor is to be used (EXAT, INVERSE or ARCTANG), otherwise exact
    public final boolean m_is_complex;
    //True if the Monte-Carlo Fitness computations are to be used
    public final boolean m_is_mc;
    //True if the Recursive Stratified Sampling (RSS) is to be used
    public final boolean m_is_rss;
    //Stores the initial sample size for the Monte Carlo sampling
    public final long m_sample_size;
    //Stores the minimum sample size the RSS is applied to
    public final long m_bisect_size;
    //Stores the fraction of sample to be used for bisection
    public final double m_bisect_ratio;

    /**
     * The basic constructor
     *
     * @param ss_size state-space size
     * @param ftn_type fitness type
     * @param attr_size the attractor size
     * @param ftn_scale the fitness function scaling factor for fitness types
     * such as INERSE and ARCTANG
     * @param is_scale true if the function is to be scaled first
     * @param is_complex true if the fitness type with attractor is to be used
     * @param is_monte_carlo true if the Monte-Carlo sampling is to be used
     * @param is_rec_strat_sample true if the Recursive Stratified Sampling
     * (RSS) is to be used
     * @param sample_size the initial sample size
     * @param min_bisect_size the minimum sample size for the RSS bisection
     * @param sample_bisect_ratio the proportion of the sample to be used to
     * figure out the bisection
     */
    public FConfig(final int ss_size, final int ftn_type,
            final double attr_size, final double ftn_scale,
            final boolean is_scale, final boolean is_complex,
            final boolean is_monte_carlo, final boolean is_rec_strat_sample,
            final long sample_size, final long min_bisect_size,
            final double sample_bisect_ratio) {
        this.m_ss_size = ss_size;
        this.m_ftn_type = ftn_type;
        this.m_attr_size = attr_size;
        this.m_ftn_scale = ftn_scale;
        this.m_is_scale = is_scale;
        this.m_is_complex = is_complex;
        this.m_is_mc = is_monte_carlo;
        this.m_is_rss = is_rec_strat_sample;
        this.m_sample_size = sample_size;
        this.m_bisect_size = min_bisect_size;
        this.m_bisect_ratio = sample_bisect_ratio;
    }

}
