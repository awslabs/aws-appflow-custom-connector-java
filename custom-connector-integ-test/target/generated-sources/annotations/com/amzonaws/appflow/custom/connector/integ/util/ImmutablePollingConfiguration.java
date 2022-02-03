package com.amzonaws.appflow.custom.connector.integ.util;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link PollingConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePollingConfiguration.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutablePollingConfiguration
    implements PollingConfiguration {
  private final int maxPollTimeS;
  private final int timeBetweenPollsS;
  private final String executionId;
  private final String flowName;

  private ImmutablePollingConfiguration(int maxPollTimeS, int timeBetweenPollsS, String executionId, String flowName) {
    this.maxPollTimeS = maxPollTimeS;
    this.timeBetweenPollsS = timeBetweenPollsS;
    this.executionId = executionId;
    this.flowName = flowName;
  }

  /**
   * @return The value of the {@code maxPollTimeS} attribute
   */
  @Override
  public int maxPollTimeS() {
    return maxPollTimeS;
  }

  /**
   * @return The value of the {@code timeBetweenPollsS} attribute
   */
  @Override
  public int timeBetweenPollsS() {
    return timeBetweenPollsS;
  }

  /**
   * @return The value of the {@code executionId} attribute
   */
  @Override
  public String executionId() {
    return executionId;
  }

  /**
   * @return The value of the {@code flowName} attribute
   */
  @Override
  public String flowName() {
    return flowName;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PollingConfiguration#maxPollTimeS() maxPollTimeS} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param maxPollTimeS A new value for maxPollTimeS
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePollingConfiguration withMaxPollTimeS(int maxPollTimeS) {
    if (this.maxPollTimeS == maxPollTimeS) return this;
    return new ImmutablePollingConfiguration(maxPollTimeS, this.timeBetweenPollsS, this.executionId, this.flowName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PollingConfiguration#timeBetweenPollsS() timeBetweenPollsS} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param timeBetweenPollsS A new value for timeBetweenPollsS
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePollingConfiguration withTimeBetweenPollsS(int timeBetweenPollsS) {
    if (this.timeBetweenPollsS == timeBetweenPollsS) return this;
    return new ImmutablePollingConfiguration(this.maxPollTimeS, timeBetweenPollsS, this.executionId, this.flowName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PollingConfiguration#executionId() executionId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param executionId A new value for executionId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePollingConfiguration withExecutionId(String executionId) {
    if (this.executionId.equals(executionId)) return this;
    String newValue = Preconditions.checkNotNull(executionId, "executionId");
    return new ImmutablePollingConfiguration(this.maxPollTimeS, this.timeBetweenPollsS, newValue, this.flowName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PollingConfiguration#flowName() flowName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param flowName A new value for flowName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePollingConfiguration withFlowName(String flowName) {
    if (this.flowName.equals(flowName)) return this;
    String newValue = Preconditions.checkNotNull(flowName, "flowName");
    return new ImmutablePollingConfiguration(this.maxPollTimeS, this.timeBetweenPollsS, this.executionId, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePollingConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePollingConfiguration
        && equalTo((ImmutablePollingConfiguration) another);
  }

  private boolean equalTo(ImmutablePollingConfiguration another) {
    return maxPollTimeS == another.maxPollTimeS
        && timeBetweenPollsS == another.timeBetweenPollsS
        && executionId.equals(another.executionId)
        && flowName.equals(another.flowName);
  }

  /**
   * Computes a hash code from attributes: {@code maxPollTimeS}, {@code timeBetweenPollsS}, {@code executionId}, {@code flowName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + maxPollTimeS;
    h = h * 17 + timeBetweenPollsS;
    h = h * 17 + executionId.hashCode();
    h = h * 17 + flowName.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PollingConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("PollingConfiguration")
        .omitNullValues()
        .add("maxPollTimeS", maxPollTimeS)
        .add("timeBetweenPollsS", timeBetweenPollsS)
        .add("executionId", executionId)
        .add("flowName", flowName)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link PollingConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PollingConfiguration instance
   */
  public static ImmutablePollingConfiguration copyOf(PollingConfiguration instance) {
    if (instance instanceof ImmutablePollingConfiguration) {
      return (ImmutablePollingConfiguration) instance;
    }
    return ImmutablePollingConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePollingConfiguration ImmutablePollingConfiguration}.
   * @return A new ImmutablePollingConfiguration builder
   */
  public static ImmutablePollingConfiguration.Builder builder() {
    return new ImmutablePollingConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePollingConfiguration ImmutablePollingConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_MAX_POLL_TIME_S = 0x1L;
    private static final long INIT_BIT_TIME_BETWEEN_POLLS_S = 0x2L;
    private static final long INIT_BIT_EXECUTION_ID = 0x4L;
    private static final long INIT_BIT_FLOW_NAME = 0x8L;
    private long initBits = 0xfL;

    private int maxPollTimeS;
    private int timeBetweenPollsS;
    private @Nullable String executionId;
    private @Nullable String flowName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PollingConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PollingConfiguration instance) {
      Preconditions.checkNotNull(instance, "instance");
      maxPollTimeS(instance.maxPollTimeS());
      timeBetweenPollsS(instance.timeBetweenPollsS());
      executionId(instance.executionId());
      flowName(instance.flowName());
      return this;
    }

    /**
     * Initializes the value for the {@link PollingConfiguration#maxPollTimeS() maxPollTimeS} attribute.
     * @param maxPollTimeS The value for maxPollTimeS 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder maxPollTimeS(int maxPollTimeS) {
      this.maxPollTimeS = maxPollTimeS;
      initBits &= ~INIT_BIT_MAX_POLL_TIME_S;
      return this;
    }

    /**
     * Initializes the value for the {@link PollingConfiguration#timeBetweenPollsS() timeBetweenPollsS} attribute.
     * @param timeBetweenPollsS The value for timeBetweenPollsS 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder timeBetweenPollsS(int timeBetweenPollsS) {
      this.timeBetweenPollsS = timeBetweenPollsS;
      initBits &= ~INIT_BIT_TIME_BETWEEN_POLLS_S;
      return this;
    }

    /**
     * Initializes the value for the {@link PollingConfiguration#executionId() executionId} attribute.
     * @param executionId The value for executionId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder executionId(String executionId) {
      this.executionId = Preconditions.checkNotNull(executionId, "executionId");
      initBits &= ~INIT_BIT_EXECUTION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link PollingConfiguration#flowName() flowName} attribute.
     * @param flowName The value for flowName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder flowName(String flowName) {
      this.flowName = Preconditions.checkNotNull(flowName, "flowName");
      initBits &= ~INIT_BIT_FLOW_NAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePollingConfiguration ImmutablePollingConfiguration}.
     * @return An immutable instance of PollingConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePollingConfiguration build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePollingConfiguration(maxPollTimeS, timeBetweenPollsS, executionId, flowName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_MAX_POLL_TIME_S) != 0) attributes.add("maxPollTimeS");
      if ((initBits & INIT_BIT_TIME_BETWEEN_POLLS_S) != 0) attributes.add("timeBetweenPollsS");
      if ((initBits & INIT_BIT_EXECUTION_ID) != 0) attributes.add("executionId");
      if ((initBits & INIT_BIT_FLOW_NAME) != 0) attributes.add("flowName");
      return "Cannot build PollingConfiguration, some of required attributes are not set " + attributes;
    }
  }
}
