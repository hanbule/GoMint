package io.gomint.math;

/**
 * @author geNAZt
 * @version 1.0
 */
public class Vector2 {

    public static final Vector2 ZERO = new Vector2( 0, 0 );

    private float x, z;

    public Vector2( float x, float z ) {
        this.x = x;
        this.z = z;
    }

    public static Vector2 getDirection2D( double angle ) {
        return new Vector2( (float) Math.cos( angle ), (float) Math.sin( angle ) );
    }

    public Vector2 add( float x, float z ) {
        return new Vector2( this.x + x, this.z + z );
    }

    public Vector2 subtract( float x, float z ) {
        return new Vector2( this.x - x, this.z - z );
    }

    public Vector2 divide( float v ) {
        return new Vector2( this.x / v, this.z / v );
    }

    public Vector2 multiply( float v ) {
        return new Vector2( this.x * v, this.z * v );
    }

    public float lengthSquared() {
        return this.x * this.x + this.z * this.z;
    }

    public Vector2 normalize() {
        float len = this.lengthSquared();
        if ( len != 0 ) {
            return this.divide( (float) Math.sqrt( len ) );
        }

        return ZERO;
    }

    public float dot(Vector2 v){
        return this.x * v.x + this.z * v.z;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Vector2{" +
            "x=" + x +
            ", z=" + z +
            '}';
    }

}
