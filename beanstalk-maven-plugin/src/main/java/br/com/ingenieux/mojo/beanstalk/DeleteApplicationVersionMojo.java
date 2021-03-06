package br.com.ingenieux.mojo.beanstalk;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.amazonaws.services.elasticbeanstalk.model.DeleteApplicationVersionRequest;

/**
 * Deletes an Application Version
 * 
 * See the docs for <a href=
 * "http://docs.amazonwebservices.com/elasticbeanstalk/latest/api/API_DeleteApplicationVersion.html"
 * >DeleteApplicationVersion API</a> call.
 * 
 * @goal delete-application-version
 * 
 * @author Aldrin Leal
 */
public class DeleteApplicationVersionMojo extends AbstractBeanstalkMojo {
	/**
	 * Delete the source bundle?
	 * 
	 * @parameter expr="${deleteSourceBundle}"
	 */
	private boolean deleteSourceBundle = false;

	@Override
	protected Object executeInternal() throws MojoExecutionException,
	    MojoFailureException {
		DeleteApplicationVersionRequest req = new DeleteApplicationVersionRequest();

		req.setApplicationName(applicationName);
		req.setDeleteSourceBundle(deleteSourceBundle);
		req.setVersionLabel(versionLabel);

		service.deleteApplicationVersion(req);

		return null;
	}

}
