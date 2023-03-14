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

import org.apache.commons.math3.util.FastMath;

import com.mhschmieder.mathtoolkit.MathConstants;

/**
 * This is an enumeration of possible resolution values for an SPL Palette. It
 * is done as an enumeration as some values are absolute and others are relative
 * to the overall SPL Dynamic Range.
 *
 * Note that there are two categories of values, where the first two are
 * strictly based on the number of unique color hues shown, and are based on
 * built-in limitations of standard color processing for basic image file types.
 *
 * The second set of values are more in the acoustics domain and are commonly
 * used in visualization contexts to help users see where values pass a
 * threshold. This is especially useful for showing where sound levels double.
 */
public enum SplPaletteResolution {
    // Although these enumeration entries seem overly verbose and unnecessary,
    // the java programming language does not allow variables to start with a
    // number vs. a letter.
    RES_256, RES_64, RES_1DB, RES_2DB, RES_3DB;

    public static final SplPaletteResolution defaultValue() {
        return RES_64;
    }

    @SuppressWarnings("nls")
    public static SplPaletteResolution fromAbbreviatedString( final String splPaletteResolutionAbbreviatedString ) {
        SplPaletteResolution splPaletteResolution = defaultValue();
        
        switch ( splPaletteResolutionAbbreviatedString ) {
        case "256":
            splPaletteResolution = RES_256;
            break;
        case "64":
            splPaletteResolution = RES_64;
            break;
        case "1db":
            splPaletteResolution = RES_1DB;
            break;
        case "2db":
            splPaletteResolution = RES_2DB;
            break;
        case "3db":
            splPaletteResolution = RES_3DB;
            break;
        default:
            break;
        }
        
        return splPaletteResolution;
    }

    @SuppressWarnings("nls")
    public final String toAbbreviatedString() {
        String abbreviatedString = "64";
        
        switch ( this ) {
        case RES_256:
            abbreviatedString = "256";
            break;
        case RES_64:
            abbreviatedString = "64";
            break;
        case RES_1DB:
            abbreviatedString = "1db";
            break;
        case RES_2DB:
            abbreviatedString = "2db";
            break;
        case RES_3DB:
            abbreviatedString = "3db";
            break;
        default:
            break;
        }
        
        return abbreviatedString;
    }

    public final int getNumberOfPaletteColors( final int splRangeDb ) {
        int numberOfPaletteColors = 64;
        
        switch ( this ) {
        case RES_256:
            numberOfPaletteColors = 256;
            break;
        case RES_64:
            numberOfPaletteColors = 64;
            break;
        case RES_1DB:
            numberOfPaletteColors = splRangeDb;
            break;
        case RES_2DB:
            numberOfPaletteColors = ( int ) FastMath.ceil( MathConstants.ONE_HALF * splRangeDb );
            break;
        case RES_3DB:
            numberOfPaletteColors = ( int ) FastMath.ceil( MathConstants.ONE_THIRD * splRangeDb );
            break;
        default:
            return 64;
        }
        
        return numberOfPaletteColors;
    }

}
