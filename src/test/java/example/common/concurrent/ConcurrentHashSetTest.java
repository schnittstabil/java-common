/*                          __    _                     
 *                         |  |  |_|___ ___ ___ ___ ___ 
 *                         |  |__| |  _| -_|   |_ -| -_|
 *                         |_____|_|___|___|_|_|___|___|
 * 
 * -----------------------------------------------------------------------------
 * Copyright (c) 2012, Michael Mayer <mm.pub@gmx.de>
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

package example.common.concurrent;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ConcurrentHashSetTest {
	private ConcurrentHashSet<String> chs;
	
	@BeforeMethod
	public void beforeMethod() {
		chs = new ConcurrentHashSet<>();
	}

	@AfterMethod
	public void afterMethod() {
		chs = null;
	}

	@Test
	public void add() {
		chs.add("abc");
		Assert.assertTrue(chs.getElements().contains("abc"));
		Assert.assertFalse(chs.getElements().contains("abcd"));
	}
}
