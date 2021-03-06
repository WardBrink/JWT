// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package jwt.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import jwt.helpers.RSAKeyPairGenerator;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Generates a new 2048 bits RSA key pair. The public key is stored in X509 format and the private key in PKCS8 format.
 */
public class GenerateRSAKeyPair extends CustomJavaAction<IMendixObject>
{
	public GenerateRSAKeyPair(IContext context)
	{
		super(context);
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		RSAKeyPairGenerator rsaKeyPairGenerator = new RSAKeyPairGenerator();
		return rsaKeyPairGenerator.generate(this.context(), 2048).getMendixObject();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "GenerateRSAKeyPair";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
