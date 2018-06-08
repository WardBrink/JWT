// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package jwt.actions;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class GenerateRSAPublicKey extends CustomJavaAction<IMendixObject>
{
	private java.lang.String modulus;
	private java.lang.String publicExponent;

	public GenerateRSAPublicKey(IContext context, java.lang.String modulus, java.lang.String publicExponent)
	{
		super(context);
		this.modulus = modulus;
		this.publicExponent = publicExponent;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent));
		RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		
		jwt.proxies.PublicKey publicKey = new jwt.proxies.PublicKey(this.context());
		Core.commit(this.context(), publicKey.getMendixObject());
		Core.storeFileDocumentContent(this.context(), publicKey.getMendixObject(), new ByteArrayInputStream(x509EncodedKeySpec.getEncoded()));
		return publicKey.getMendixObject();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "GenerateRSAPublicKey";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}