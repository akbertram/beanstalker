package br.com.ingenieux.mojo.beanstalk;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.amazonaws.services.elasticbeanstalk.model.UpdateEnvironmentRequest;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.util.Arrays;

/**
 * Updates the environment description, deploys a new application version,
 * updates the configuration settings to an entirely new configuration template,
 * or updates select configuration option values in the running environment
 * 
 * See the <a href=
 * "http://docs.amazonwebservices.com/elasticbeanstalk/latest/api/API_UpdateEnvironment.html"
 * >UpdateEnvironment API</a> call.
 * 
 * @goal update-environment-configuration-settings
 */
public class UpdateEnvironmentConfigurationSettingsMojo extends AbstractBeanstalkMojo {
	protected Object executeInternal() throws MojoExecutionException,
	    MojoFailureException {
		UpdateEnvironmentRequest req = new UpdateEnvironmentRequest()
		    .withEnvironmentName(environmentName)
		    .withOptionSettings(Arrays.asList(optionSettings))
		    .withOptionsToRemove(getOptionsToRemove());

		return service.updateEnvironment(req);
	}
}
