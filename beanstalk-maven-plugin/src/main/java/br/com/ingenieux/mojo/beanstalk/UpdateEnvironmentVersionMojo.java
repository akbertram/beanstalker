package br.com.ingenieux.mojo.beanstalk;

import com.amazonaws.services.elasticbeanstalk.model.UpdateEnvironmentRequest;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Deploys a new application version.
 *
 * See the <a href=
 * "http://docs.amazonwebservices.com/elasticbeanstalk/latest/api/API_UpdateEnvironment.html"
 * >UpdateEnvironment API</a> call.
 *
 * @goal update-environment-version
 */
public class UpdateEnvironmentVersionMojo extends AbstractBeanstalkMojo {
	protected Object executeInternal() throws MojoExecutionException,
        MojoFailureException {
		UpdateEnvironmentRequest req = new UpdateEnvironmentRequest()
		    .withEnvironmentName(environmentName)
            .withVersionLabel(versionLabel);

		return service.updateEnvironment(req);
	}
}
