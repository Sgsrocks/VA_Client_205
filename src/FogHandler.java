/**
 * 
 * @author Zion
 *
 */
public class FogHandler {

	public int fogColor = 0x959698;
	private int fogStartDistance = 2750;
	private int fogEndDistance = 3250;
	
	public void renderFog(int[] colorBuffer, float[] depthBuffer) {
        float fogLength = fogEndDistance - fogStartDistance;
        for (int index = 0; index < colorBuffer.length; index++) {
            int relative = ((int) depthBuffer[index] - fogStartDistance);
            float factor = Math.min(1f, Math.max(relative / fogLength, 0f));
            colorBuffer[index] = FogUtil.mix(colorBuffer[index], fogColor, factor);
        }
	}
}