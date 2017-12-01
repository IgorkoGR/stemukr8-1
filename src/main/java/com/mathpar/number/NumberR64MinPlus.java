package com.mathpar.number;

import java.util.Random;

/**
 * Class NumberR64MaxPlus provides troplcal operations over NumberR64 number:
 *
 * @author gennadi
 * @version 4.1 04/11/11
 * @since ParCA 4.1
 */
public class NumberR64MinPlus extends NumberR64 {
    public static NumberR64MinPlus ONE = new NumberR64MinPlus(NumberR64.ZERO);
    public static Element ZERO = POSITIVE_INFINITY;
    public static NumberR64MinPlus MINUS_ONE = new NumberR64MinPlus(NumberR64.MINUS_ONE);

    public NumberR64MinPlus() {
    }

    @Override
    public NumberR64MinPlus one(Ring ring) {
        return NumberR64MinPlus.ONE;
    }

    @Override
    public NumberR64MinPlus minus_one(Ring ring) {
        return new NumberR64MinPlus(NumberR64.MINUS_ONE);
    }

    @Override
    public int numbElementType() {
        return Ring.R64MinPlus;
    }

    @Override
    public Element zero(Ring ring) {
        return NumberR64MinPlus.ZERO;
    }

    @Override
    public NumberR64MinPlus myOne(Ring ring) {
        return NumberR64MinPlus.ONE;
    }

    @Override
    public Element myZero(Ring ring) {
        return NumberR64MinPlus.ZERO;
    }

    public NumberR64MinPlus(NumberR64 p) {
        this.value = p.value;
    }

    public NumberR64MinPlus(NumberR64 p, Ring ring) {
        this.value = p.value;
    }

    public NumberR64MinPlus(String s, Ring ring) {
        NumberR64 p = new NumberR64(s);
        this.value = p.value;
    }

    @Override
    public Boolean isZero(Ring ring) {
        return this == ring.numberZERO;
    }

    @Override
    public Boolean isOne(Ring ring) {
        double e = ring.MachineEpsilonR64.value;
        return (value < e) && (value > -e);
    }

    @Override
    public Element add(Element val, Ring ring) {
        return (val == NAN) ? NAN
                : (this == NEGATIVE_INFINITY || val == NEGATIVE_INFINITY) ? NEGATIVE_INFINITY
                : (this == POSITIVE_INFINITY) ? val
                : (val == POSITIVE_INFINITY) ? this : (compareTo(val, ring) > 0 ? this : val);
    }

    @Override
    public Element multiply(Element val, Ring ring) {
        //NumberR64MinPlus vval = (NumberR64MinPlus) val;
        return (val == NAN) ? NAN
                : (this == POSITIVE_INFINITY)
                ? (val == NEGATIVE_INFINITY) ? NAN : this
                : (this == NEGATIVE_INFINITY)
                ? (val == POSITIVE_INFINITY) ? NAN : this
                : (val == POSITIVE_INFINITY)
                ? val
                : (val == NEGATIVE_INFINITY) ? val : new NumberR64MinPlus(((NumberR64) this).add((NumberR64) val));
    }

    @Override
    public Element divide(Element val, Ring ring) {
        if (val==POSITIVE_INFINITY) return NEGATIVE_INFINITY;
        return new NumberR64MinPlus(((NumberR64) this).subtract((NumberR64) val));
    }

    @Override
    public NumberR64MaxPlus negate(Ring ring) {
        return new NumberR64MaxPlus(new NumberR64(-value));
    }

    @Override
    public Element inverse(Ring ring) {
        return (this == NAN) ? NAN
                : (this == ZERO) ? NEGATIVE_INFINITY
                : (this == NEGATIVE_INFINITY) ? ZERO
                : new NumberR64MinPlus(((NumberR64) this).negate(ring));
    }

    /**
     * Вычисляет число 1 + x + x^2 + ...
     * @param ring
     * @return
     */
    @Override
    public Element closure(Ring ring){
        if(this.compareTo(ring.numberONE, -1, ring)) return ONE;
        else return NEGATIVE_INFINITY;
    }

    @Override
    public int compareTo(Element x, Ring ring) {
        if ((x == NAN) || (this == NAN)) {
            return Integer.MAX_VALUE;
        }
        if (x == POSITIVE_INFINITY) {
            return (this == POSITIVE_INFINITY) ? 0 : 1;
        }
        if (this == POSITIVE_INFINITY) {
            return -1;
        }
        if (x == NEGATIVE_INFINITY) {
            return (this == NEGATIVE_INFINITY) ? 0 : -1;
        }
        if (this == NEGATIVE_INFINITY) {
            return 1;
        }
        if(x.isInfinite()) {
            return -x.compareTo(this, ring);
        }
        int v = x.numbElementType();
        int m1 = Ring.R64;
        int m2 = Ring.R64MinMax;
        if (m1 > v) {
            return -1;
        } else if (m2 < v) {
            return 1;
        } else {
            double y = value - ((NumberR64) x).value;
            if (Math.abs(y) < ring.MachineEpsilonR64.value) {
                return 0;
            }
            return (y > 0) ? -1 : 1;
        }
    }

    @Override
    public NumberR64MinPlus valOf(double x, Ring ring) {
        return this;
    }

    @Override
    public NumberR64MinPlus valOf(int x, Ring ring) {
        return this;
    }

    @Override
    public NumberR64MinPlus valOf(long x, Ring ring) {
        return new NumberR64MinPlus(NumberR64.valueOf(x), ring);
    }

    @Override
    public NumberR64MinPlus valOf(String s, Ring ring) {
        return (new NumberR64MinPlus(s, ring));
    }

    @Override
    public Element D(Ring r) {
        return ZERO;
    }

    @Override
    public Element D(int num, Ring r) {
        return ZERO;
    }

    @Override
    public NumberR64MinPlus random(int[] randomType, Random rnd, Ring ring) {
        return new NumberR64MinPlus(NumberR64.ONE.random(randomType, rnd, ring));
    }
    
    /**
     * Transforms this number of NumberR64MinPlus type to given type defined in Ring.
     *
     * @param numberType new type
     * @param ring
     *
     * @return this transormed to the new type
     */
    @Override
    public Element toNumber(int numberType, Ring ring) {
        if (numberType < Ring.Complex) {
            switch (numberType) {
                case Ring.Z:
                    return (new NumberR(value)).NumberRtoNumberZ();
                case Ring.Z64:
                    return new NumberZ64(longValue());
                case Ring.Zp32:
                    return new NumberZp32(longValue());
                case Ring.Zp:
                    return new NumberZp((new NumberR(value)).NumberRtoNumberZ(), ring);
                case Ring.R:
                    return new NumberR(value);
                case Ring.R64:
                    return new NumberR64(value);
                case Ring.R128:
                    return new NumberR128(value);
                case Ring.C64:
                    return new Complex(value);
                case Ring.Q:
                    double denom = Math.pow(10, ring.FLOATPOS);
                    double dd = value * denom;
                    NumberZ n = (new NumberR(dd)).NumberRtoNumberZ();
                    NumberZ d = (new NumberR(denom)).NumberRtoNumberZ();
                    return new Fraction(n, d).cancel(ring);
                case Ring.R64MaxPlus:
                    return new NumberR64MaxPlus(new NumberR64(value));
                case Ring.R64MinPlus:
                    return this;
                case Ring.R64MaxMult:
                    return new NumberR64MaxMult(new NumberR64(value));
                case Ring.R64MinMult:
                    return new NumberR64MinMult(new NumberR64(value));
                case Ring.R64MaxMin:
                    return new NumberR64MaxMin(new NumberR64(value));
                case Ring.R64MinMax:
                    return new NumberR64MinMax(new NumberR64(value));
                case Ring.RMaxPlus:
                    return new NumberRMaxPlus(new NumberR(value));
                case Ring.RMinPlus:
                    return new NumberRMinPlus(new NumberR(value));
                case Ring.RMaxMult:
                    return new NumberRMaxMult(new NumberR(value));
                case Ring.RMinMult:
                    return new NumberRMinMult(new NumberR(value));
                case Ring.RMaxMin:
                    return new NumberRMaxMin(new NumberR(value));
                case Ring.RMinMax:
                    return new NumberRMinMax(new NumberR(value));
                case Ring.ZMaxPlus:
                    return new NumberZMaxPlus(new NumberZ(longValue()));
                case Ring.ZMinPlus:
                    return new NumberZMinPlus(new NumberZ(longValue()));
                case Ring.ZMaxMult:
                    return new NumberZMaxMult(new NumberZ(longValue()));
                case Ring.ZMinMult:
                    return new NumberZMinMult(new NumberZ(longValue()));
                case Ring.ZMaxMin:
                    return new NumberZMaxMin(new NumberZ(longValue()));
                case Ring.ZMinMax:
                    return new NumberZMinMax(new NumberZ(longValue()));
            }
        } else if (numberType < Ring.Polynom) {
            Element re = toNumber(numberType - Ring.Complex, ring);
            return new Complex(re, re.zero(ring));
        }
        return null;
    }
    
    @Override
    public Element toNewRing(int Algebra, Ring r) {
        return toNumber(Algebra, r);
    }
}
