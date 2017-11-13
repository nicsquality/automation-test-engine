/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2014, Montreal PROT, or individual contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Montreal PROT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.bigtester.ate.model.page.atewebdriver;

import java.util.Optional;

import org.eclipse.jdt.annotation.Nullable;
import org.openqa.selenium.WebDriver;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMyWebDriver defines ....
 *
 * @author Peidong Hu
 */
public interface IMyWebDriver {

	/**
	 * Creates the driver.
	 *
	 * @return the web driver
	 */
	WebDriver getWebDriverInstance();

	/**
	 * Gets the webdriver.
	 *
	 * @return the webdriver
	 */
	@Nullable WebDriver getWebDriver();

	/**
	 * Gets the browser windows monitor.
	 *
	 * @return the browser windows monitor
	 */
	IMultiWindowsHandler getMultiWindowsHandler();

	void setMultiWindowsHandler(IMultiWindowsHandler multiWindowsHandler);
	/**
	 * Save screen shot. if pathFileName supplied,
	 *
	 * @param pathFileName the path file name
	 * @return the string
	 */
	Optional<String> saveScreenShot(Optional<String> pathFileName);

	/**
	 * Save screen shot.
	 *
	 * @return the optional
	 */
	Optional<String> saveScreenShot();


}
