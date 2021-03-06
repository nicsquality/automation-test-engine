/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2015, Montreal PROT, or individual contributors as
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
package org.bigtester.ate.test.model.page.elementaction;


import org.bigtester.ate.GlobalUtils;

import org.bigtester.ate.model.page.atewebdriver.exception.BrowserUnexpectedException;
import org.bigtester.ate.model.page.elementaction.IElementAction;
import org.bigtester.ate.model.page.elementaction.ITestObjectAction;
import org.bigtester.ate.model.data.IStepInputData;
import org.bigtester.ate.model.data.exception.RuntimeDataException;
import org.bigtester.ate.model.page.exception.PageValidationException;
import org.bigtester.ate.model.page.exception.StepExecutionException;
import org.bigtester.ate.model.page.page.MyWebElement;
import org.bigtester.ate.test.AbstractBigtesterStepTest;
import org.eclipse.jdt.annotation.Nullable;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * 
 * @author Peidong Hu
 *
 */
//@ContextConfiguration(locations = { "classpath:bigtesterTestNG/testSuite01/assignValueAction.xml" })
public class AssignValueActionTest extends AbstractBigtesterStepTest {

	/** The my web e. */
	@Nullable
	private transient MyWebElement<?> myWebE;
	/**
	 * Ead test.
	 * 
	 * @throws RuntimeDataException
	 * @throws PageValidationException
	 * @throws StepExecutionException 
	 * @throws InterruptedException 
	 * @throws BrowserUnexpectedException 
	 */
	//@Test(priority = 1)
	public void assignValueEADTest() throws PageValidationException,
			RuntimeDataException, StepExecutionException, InterruptedException, BrowserUnexpectedException {
		getTestPage("bigtesterTestNG/aut/textarea.html");

		MyWebElement<?> assignV = (MyWebElement<?>) getApplicationContext()
				.getBean("eadAssignValue");
		//assignV.doAction();
		this.runElementTestStep(assignV);
		
		
		MyWebElement<?> prependAssignV = (MyWebElement<?>) getApplicationContext()
				.getBean("eadAssignValuePrepend");
		//prependAssignV.doAction();
		this.runElementTestStep(prependAssignV);
		
		MyWebElement<?> appendAssignV = (MyWebElement<?>) getApplicationContext()
				.getBean("eadAssignValueAppend");
		//appendAssignV.doAction();
		this.runElementTestStep(appendAssignV);
		
		
		ITestObjectAction<?> prependActObj = (ITestObjectAction<?>) prependAssignV.getTestObjectAction();
		
		ITestObjectAction<?> appendActObj = (ITestObjectAction<?>) appendAssignV.getTestObjectAction();
		
		ITestObjectAction<?> replaceActObj = (ITestObjectAction<?>) assignV.getTestObjectAction();
		if (prependActObj == null || appendActObj == null || replaceActObj == null) {
			Assert.assertTrue(false);
		} else {
			IStepInputData prependInp = ((IElementAction) prependActObj).getDataValue();
			IStepInputData appendInp = ((IElementAction) appendActObj).getDataValue();
			IStepInputData replaceInp = ((IElementAction) replaceActObj).getDataValue();
			
			 if (prependInp == null || appendInp == null || replaceInp == null) {
				 Assert.assertTrue(false);
			 } else {
				 String expectedVal = prependInp.getStrDataValue()  + replaceInp.getStrDataValue() + appendInp.getStrDataValue();
				 String actualVal = getMyDriver().getWebDriverInstance().findElements(new By.ByTagName("textarea")).get(0).getAttribute("value");
				 Assert.assertTrue(expectedVal.equals(actualVal));
			 }
		
		}
		
		
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public MyWebElement<?> getMyWebElement() {
			final MyWebElement<?> myWebE2 = myWebE;
			if (myWebE2 == null) {
				throw GlobalUtils.createNotInitializedException("myWebe");
			} else {
				return myWebE2;
			}
		}
}
