package com.amazonaws.appflow.custom.connector.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CacheControl}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCacheControl.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableCacheControl implements CacheControl {
  private final long timeToLive;
  private final @Nullable TimeUnit timeToLiveUnit;

  private ImmutableCacheControl(long timeToLive, @Nullable TimeUnit timeToLiveUnit) {
    this.timeToLive = timeToLive;
    this.timeToLiveUnit = timeToLiveUnit;
  }

  /**
   * Time to keep the metadata in cache.
   * Return a large number when entity metadata is not dynamic and can
   * be cached for long time. The minimum allowed value is 600 seconds.
   */
  @JsonProperty("timeToLive")
  @Override
  public long timeToLive() {
    return timeToLive;
  }

  /**
   * TimeUnit for the timeToLive.
   */
  @JsonProperty("timeToLiveUnit")
  @Override
  public @Nullable TimeUnit timeToLiveUnit() {
    return timeToLiveUnit;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CacheControl#timeToLive() timeToLive} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param timeToLive A new value for timeToLive
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCacheControl withTimeToLive(long timeToLive) {
    if (this.timeToLive == timeToLive) return this;
    return new ImmutableCacheControl(timeToLive, this.timeToLiveUnit);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CacheControl#timeToLiveUnit() timeToLiveUnit} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param timeToLiveUnit A new value for timeToLiveUnit (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCacheControl withTimeToLiveUnit(@Nullable TimeUnit timeToLiveUnit) {
    if (this.timeToLiveUnit == timeToLiveUnit) return this;
    return new ImmutableCacheControl(this.timeToLive, timeToLiveUnit);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCacheControl} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCacheControl
        && equalTo((ImmutableCacheControl) another);
  }

  private boolean equalTo(ImmutableCacheControl another) {
    return timeToLive == another.timeToLive
        && Objects.equal(timeToLiveUnit, another.timeToLiveUnit);
  }

  /**
   * Computes a hash code from attributes: {@code timeToLive}, {@code timeToLiveUnit}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Longs.hashCode(timeToLive);
    h = h * 17 + Objects.hashCode(timeToLiveUnit);
    return h;
  }

  /**
   * Prints the immutable value {@code CacheControl} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CacheControl")
        .omitNullValues()
        .add("timeToLive", timeToLive)
        .add("timeToLiveUnit", timeToLiveUnit)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements CacheControl {
    long timeToLive;
    boolean timeToLiveIsSet;
    @Nullable TimeUnit timeToLiveUnit;
    @JsonProperty("timeToLive")
    public void setTimeToLive(long timeToLive) {
      this.timeToLive = timeToLive;
      this.timeToLiveIsSet = true;
    }
    @JsonProperty("timeToLiveUnit")
    public void setTimeToLiveUnit(@Nullable TimeUnit timeToLiveUnit) {
      this.timeToLiveUnit = timeToLiveUnit;
    }
    @Override
    public long timeToLive() { throw new UnsupportedOperationException(); }
    @Override
    public TimeUnit timeToLiveUnit() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableCacheControl fromJson(Json json) {
    ImmutableCacheControl.Builder builder = ImmutableCacheControl.builder();
    if (json.timeToLiveIsSet) {
      builder.timeToLive(json.timeToLive);
    }
    if (json.timeToLiveUnit != null) {
      builder.timeToLiveUnit(json.timeToLiveUnit);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CacheControl} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CacheControl instance
   */
  public static ImmutableCacheControl copyOf(CacheControl instance) {
    if (instance instanceof ImmutableCacheControl) {
      return (ImmutableCacheControl) instance;
    }
    return ImmutableCacheControl.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCacheControl ImmutableCacheControl}.
   * @return A new ImmutableCacheControl builder
   */
  public static ImmutableCacheControl.Builder builder() {
    return new ImmutableCacheControl.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCacheControl ImmutableCacheControl}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TIME_TO_LIVE = 0x1L;
    private long initBits = 0x1L;

    private long timeToLive;
    private @Nullable TimeUnit timeToLiveUnit;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CacheControl} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CacheControl instance) {
      Preconditions.checkNotNull(instance, "instance");
      timeToLive(instance.timeToLive());
      @Nullable TimeUnit timeToLiveUnitValue = instance.timeToLiveUnit();
      if (timeToLiveUnitValue != null) {
        timeToLiveUnit(timeToLiveUnitValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link CacheControl#timeToLive() timeToLive} attribute.
     * @param timeToLive The value for timeToLive 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder timeToLive(long timeToLive) {
      this.timeToLive = timeToLive;
      initBits &= ~INIT_BIT_TIME_TO_LIVE;
      return this;
    }

    /**
     * Initializes the value for the {@link CacheControl#timeToLiveUnit() timeToLiveUnit} attribute.
     * @param timeToLiveUnit The value for timeToLiveUnit (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder timeToLiveUnit(@Nullable TimeUnit timeToLiveUnit) {
      this.timeToLiveUnit = timeToLiveUnit;
      return this;
    }

    /**
     * Builds a new {@link ImmutableCacheControl ImmutableCacheControl}.
     * @return An immutable instance of CacheControl
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCacheControl build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCacheControl(timeToLive, timeToLiveUnit);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TIME_TO_LIVE) != 0) attributes.add("timeToLive");
      return "Cannot build CacheControl, some of required attributes are not set " + attributes;
    }
  }
}
