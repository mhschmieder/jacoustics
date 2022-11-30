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
 * Smoothing generally refers to operations over specific Frequency Band Q
 * Factors.
 */
public enum Smoothing {
    NARROW_BAND, SIXTH_OCTAVE_BAND, THIRD_OCTAVE_BAND;

    public static final Smoothing defaultValue() {
        return NARROW_BAND;
    }

    public static final Smoothing fromOctaveDivider( final int octaveDivider ) {
        Smoothing smoothing = defaultValue();
        
        switch ( octaveDivider ) {
        case 0:
            smoothing = NARROW_BAND;
            break;
        case 6:
            smoothing = SIXTH_OCTAVE_BAND;
            break;
        case 3:
            smoothing = THIRD_OCTAVE_BAND;
            break;
        default:
            break; 
        }
        
        return smoothing;
    }

    public static final int toOctaveDivider( final Smoothing smoothing ) {
        int octaveDivider = -1;
        
        switch ( smoothing ) {
        case NARROW_BAND:
            octaveDivider = 0;
            break;
        case SIXTH_OCTAVE_BAND:
            octaveDivider = 6;
            break;
        case THIRD_OCTAVE_BAND:
            octaveDivider = 3;
            break;
        default:
            final String errMessage = "Unexpected " + smoothing.getClass().getSimpleName() + " " //$NON-NLS-1$ //$NON-NLS-2$
                    + smoothing;
            throw new IllegalArgumentException( errMessage );
        }
        
        return octaveDivider;
    }

    public static final Smoothing fromPresentationString( final String smoothingPresentationString ) {
        Smoothing smoothing = defaultValue();
        
        switch ( smoothingPresentationString ) {
        case "No Smoothing": //$NON-NLS-1$
            smoothing = NARROW_BAND;
            break;
        case "1/6 Octave Smoothing": //$NON-NLS-1$ :
            smoothing = SIXTH_OCTAVE_BAND;
            break;
        case "1/3 Octave Smoothing": //$NON-NLS-1$
            smoothing = THIRD_OCTAVE_BAND;
            break;
        default:
            break;
        }
        
        return smoothing;
    }

    public static final String toPresentationString( final Smoothing smoothing ) {
        String presentationString = null;
        
        switch ( smoothing ) {
        case NARROW_BAND:
            presentationString = "No Smoothing"; //$NON-NLS-1$
            break;
        case SIXTH_OCTAVE_BAND:
            presentationString = "1/6 Octave Smoothing"; //$NON-NLS-1$
            break;
        case THIRD_OCTAVE_BAND:
            presentationString = "1/3 Octave Smoothing"; //$NON-NLS-1$
            break;
        default:
            final String errMessage = "Unexpected " + smoothing.getClass().getSimpleName() + " " //$NON-NLS-1$ //$NON-NLS-2$
                    + smoothing;
            throw new IllegalArgumentException( errMessage );
        }
        
        return presentationString;
    }

    public final int toOctaveDivider() {
        return toOctaveDivider( this );
    }

    public final String toPresentationString() {
        return toPresentationString( this );
    }

}
