/**
 * MIT License
 *
 * Copyright (c) 2020, 2022 Mark Schmieder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the PhysicsToolkit Library
 *
 * You should have received a copy of the MIT License along with the
 * PhysicsToolkit Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/physicstoolkit
 */
package com.mhschmieder.acousticstoolkit;

/**
 * Relative Bandwidth is a coarser concept than "Q" and is more specific to
 * particular acoustic engineering contexts where one is often more focused on
 * the practicalities of which center frequencies can be easily measured for
 * their response. The official definition dictionary definition is as follows:
 *
 * For an electric filter, the ratio of the bandwidth being considered to a
 * specified reference bandwidth, such as the bandwidth between frequencies at
 * which there is an attenuation of 3 decibels.
 *
 * This specific enumeration is meant to represent typical acoustical
 * measurement and detection environments, most commonly with a focus on what
 * are useful frequencies for evaluation and analysis, such as for music but
 * also for audio signals related to marine mammals, environment, sonar, etc.
 *
 * TODO: Expand this to also cover Relative Bandwidths that are multiple
 * octaves? No need to expand in the other direction, as 1/48 octave is in
 * most cases a single frequency (depending on the octave range context).
 */
public enum RelativeBandwidth {
    ONE_OCTAVE, THIRD_OCTAVE, SIXTH_OCTAVE, TWELTH_OCTAVE, TWENTYFOURTH_OCTAVE, FORTYEIGHTH_OCTAVE;

    public static RelativeBandwidth defaultValue() {
        return THIRD_OCTAVE;
    }

    /**
     * Returns the octave divider corresponding to the Relative Bandwidth,
     * which is always an integer and can be used as the denominator in various
     * acoustical calculations.
     *
     * @param relativeBandwidth
     *            The Relative bandwidth to convert to an Octave Divider
     * @return The integer value corresponding to the division factor to apply
     *         relative to a full octave, for the provided Relative Bandwidth
     *         value
     */
    public static int toOctaveDivider( final RelativeBandwidth relativeBandwidth ) {
        int octaveDivider = 3;
        
        switch ( relativeBandwidth ) {
        case ONE_OCTAVE:
            octaveDivider = 1;
            break;
        case THIRD_OCTAVE:
            octaveDivider = 3;
            break;
        case SIXTH_OCTAVE:
            octaveDivider = 6;
            break;
        case TWELTH_OCTAVE:
            octaveDivider = 12;
            break;
        case TWENTYFOURTH_OCTAVE:
            octaveDivider = 24;
            break;
        case FORTYEIGHTH_OCTAVE:
            octaveDivider = 48;
            break;
        default:
            break;
        }
        
        return octaveDivider;
    }

    /**
     * Returns the Relative Bandwidth corresponding to a provided presentation
     * value (string).
     *
     * @param relativeBandwidthPresentationString
     *            The Relative Bandwidth presentation value to convert
     * @return The Relative bandwidth corresponding to a provided presentation
     *         value (string)
     */
    @SuppressWarnings("nls")
    public static RelativeBandwidth fromPresentationString( final String relativeBandwidthPresentationString ) {
        RelativeBandwidth relativeBandwidth = defaultValue();
        
        switch ( relativeBandwidthPresentationString ) {
        case "1 octave":
            relativeBandwidth = ONE_OCTAVE;
            break;
        case "1/3 octave":
            relativeBandwidth = THIRD_OCTAVE;
            break;
        case "1/6 octave":
            relativeBandwidth = SIXTH_OCTAVE;
            break;
        case "1/12 octave":
            relativeBandwidth = TWELTH_OCTAVE;
            break;
        case "1/24 octave":
            relativeBandwidth = TWENTYFOURTH_OCTAVE;
            break;
        case "1/48 octave":
            relativeBandwidth = FORTYEIGHTH_OCTAVE;
            break;
        default:
            break;
        }
        
        return relativeBandwidth;
    }

    /**
     * Returns a presentation value (string) for the Relative Bandwidth, whether
     * for saving in a file or presenting on the screen in a GUI context.
     *
     * @param relativeBandwidth
     *            The Relative Bandwidth to convert to a presentation value
     * @return A presentation value (string) for the provided Relative Bandwidth
     */
    @SuppressWarnings("nls")
    public static String toPresentationString( final RelativeBandwidth relativeBandwidth ) {
        return toAbbreviatedString( relativeBandwidth ) + " octave";
    }

    /**
     * Returns the Relative Bandwidth corresponding to a provided abbreviated
     * value (string).
     *
     * @param relativeBandwidthAbbreviatedString
     *            The Relative Bandwidth presentation value to convert
     * @return The Relative bandwidth corresponding to a provided abbreviated
     *         value (string)
     */
    @SuppressWarnings("nls")
    public static RelativeBandwidth fromAbbreviatedString( final String relativeBandwidthAbbreviatedString ) {
        return fromPresentationString( relativeBandwidthAbbreviatedString + " octave" );
    }

    /**
     * Returns an abbreviated value (string) for the Relative Bandwidth, whether
     * for saving in a file or presenting on the screen in a GUI context.
     *
     * @param relativeBandwidth
     *            The Relative Bandwidth to convert to an abbreviated value
     * @return An abbreviated value (string) for the provided Relative Bandwidth
     */
    @SuppressWarnings("nls")
    public static String toAbbreviatedString( final RelativeBandwidth relativeBandwidth ) {
        String abbreviatedString = defaultValue().toAbbreviatedString();
        
        switch ( relativeBandwidth ) {
        case ONE_OCTAVE:
            abbreviatedString = "1";
            break;
        case THIRD_OCTAVE:
            abbreviatedString = "1/3";
            break;
        case SIXTH_OCTAVE:
            abbreviatedString = "1/6";
            break;
        case TWELTH_OCTAVE:
            abbreviatedString = "1/12";
            break;
        case TWENTYFOURTH_OCTAVE:
            abbreviatedString = "1/24";
            break;
        case FORTYEIGHTH_OCTAVE:
            abbreviatedString = "1/48";
            break;
        default:
            break;
        }
        
        return abbreviatedString;
    }

    /**
     * Returns the octave divider corresponding to the Relative Bandwidth,
     * which is always an integer and can be used as the denominator in various
     * acoustical calculations.
     *
     * @return The integer value corresponding to the division factor to apply
     *         relative to a full octave, for this Relative Bandwidth value
     */
    public final int toOctaveDivider() {
        return toOctaveDivider( this );
    }

    /**
     * Returns a presentation value (string) for the Relative Bandwidth, whether
     * for saving in a file or presenting on the screen in a GUI context.
     *
     * @return A presentation value (string) for this Relative Bandwidth
     */
    public final String toPresentationString() {
        return toPresentationString( this );
    }

    /**
     * Returns an abbreviated value (string) for the Relative Bandwidth, whether
     * for saving in a file or presenting on the screen in a GUI context.
     *
     * @return An abbreviated value (string) for this Relative Bandwidth
     */
    public final String toAbbreviatedString() {
        return toAbbreviatedString( this );
    }

}
