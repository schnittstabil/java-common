/*                          __    _                     
 *                         |  |  |_|___ ___ ___ ___ ___ 
 *                         |  |__| |  _| -_|   |_ -| -_|
 *                         |_____|_|___|___|_|_|___|___|
 * 
 * -----------------------------------------------------------------------------
 * Copyright (c) 2012-2013, Michael Mayer <michael@schnittstabil.de>
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * -----------------------------------------------------------------------------
 *                                                       (BSD 2-Clause License)
 */

package de.schnittstabil.common.concurrent;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A lock free implementation inspired by {@link java.util.HashSet}, without the
 * clutter of the {@link java.util.Set} interface.
 * 
 * TODO benchmark against {@link ConcurrentIdentityMap}
 * 
 * @author Michael Mayer
 */
public class ConcurrentHashSet<E> {
	private final ConcurrentHashMap<E, Object> map;
	private static final Object PRESENT = new Object();

	public ConcurrentHashSet() {
		map = new ConcurrentHashMap<>();
	}

	/**
	 * See {@link java.util.HashSet#add(Object)}.
	 * 
	 * @param e
	 *            the element to add
	 * @return {@code false} if this set did already contain the element
	 *         {@code e}
	 */
	public boolean add(E e) {
		return map.put(e, PRESENT) == null;
	}

	/**
	 * Retruns the elements of the set.
	 * 
	 * @return the elements of the set
	 */
	public Collection<E> getElements() {
		return map.keySet();
	}
}
