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

import org.apache.maven.plugin.MojoExecutionException;
import org.codehaus.plexus.util.StringUtils;

import com.amazonaws.services.elasticbeanstalk.model.CreateApplicationVersionRequest;
import com.amazonaws.services.elasticbeanstalk.model.CreateApplicationVersionResult;
import com.amazonaws.services.elasticbeanstalk.model.S3Location;

/**
 * Creates an Application Version, optionally creating the application itself.
 * 
 * See the <a href=
 * "http://docs.amazonwebservices.com/elasticbeanstalk/latest/api/API_CreateApplicationVersion.html"
 * >CreateApplicationVersion API</a> call.
 * 
 * @goal create-application-version
 */
public class CreateApplicationVersionMojo extends AbstractBeanstalkMojo {
	protected Object executeInternal() throws MojoExecutionException {
		CreateApplicationVersionRequest request = new CreateApplicationVersionRequest();

		request.setApplicationName(applicationName);
		request.setDescription(applicationDescription);
		request.setAutoCreateApplication(autoCreateApplication);

		if (StringUtils.isNotBlank(s3Bucket) && StringUtils.isNotBlank(s3Key))
			request.setSourceBundle(new S3Location(s3Bucket, s3Key));

		request.setDescription(applicationDescription);

		request.setVersionLabel(versionLabel);

		CreateApplicationVersionResult result = service
		    .createApplicationVersion(request);

		return result.getApplicationVersion();
	}
}
