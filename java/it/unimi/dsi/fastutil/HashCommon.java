/*		 
 * fastUtil 1.2: Fast & compact specialized hash-based utility classes for Java
 *
 * Copyright (C) 2002 Sebastiano Vigna 
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2, or (at your option) any
 * later version.
 *	
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *	
 * You should have received a copy of the GNU General Public License along
 * with this program; see the file COPYING.  If not, write to the Free
 * Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 */

package it.unimi.dsi.fastUtil;

/** Common code for all hash-based classes.
 *
 * All hashing in <code>fastUtil</code> is performed starting from a 32-bit integer
 * associated to a key or value. For all integer types smaller than <code>long</code>, we
 * just cast. In all other cases, we do some conversion using static code in this
 * class.
 */

public class HashCommon {

	 private HashCommon() {};

	 /* To get an integer from a integer type smaller than long, we just cast.
	  * In all other cases, we need some support functions. 
	  */

	 final static int float2int(final float f) {
		  return Float.floatToRawIntBits(f);
	 }

	 final static int double2int(final double d) {
		  final long l = Double.doubleToRawLongBits(d);
		  return (int)(l ^ (l >>> 32));
	 }

	 final static int long2int(final long l) {
		  return (int)(l ^ (l >>> 32));
	 }
}

