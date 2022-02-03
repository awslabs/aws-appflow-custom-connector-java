package com.amazonaws.appflow.custom.connector.example;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link SalesforceResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSalesforceResponse.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableSalesforceResponse
    implements SalesforceResponse {
  private final int statusCode;
  private final @Nullable String response;
  private final String errorReason;

  private ImmutableSalesforceResponse(int statusCode, @Nullable String response, String errorReason) {
    this.statusCode = statusCode;
    this.response = response;
    this.errorReason = errorReason;
  }

  /**
   * @return The value of the {@code statusCode} attribute
   */
  @Override
  public int statusCode() {
    return statusCode;
  }

  /**
   * @return The value of the {@code response} attribute
   */
  @Override
  public @Nullable String response() {
    return response;
  }

  /**
   * @return The value of the {@code errorReason} attribute
   */
  @Override
  public String errorReason() {
    return errorReason;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link SalesforceResponse#statusCode() statusCode} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param statusCode A new value for statusCode
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSalesforceResponse withStatusCode(int statusCode) {
    if (this.statusCode == statusCode) return this;
    return new ImmutableSalesforceResponse(statusCode, this.response, this.errorReason);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link SalesforceResponse#response() response} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param response A new value for response (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSalesforceResponse withResponse(@Nullable String response) {
    if (Objects.equal(this.response, response)) return this;
    return new ImmutableSalesforceResponse(this.statusCode, response, this.errorReason);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link SalesforceResponse#errorReason() errorReason} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param errorReason A new value for errorReason
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSalesforceResponse withErrorReason(String errorReason) {
    if (this.errorReason.equals(errorReason)) return this;
    String newValue = Preconditions.checkNotNull(errorReason, "errorReason");
    return new ImmutableSalesforceResponse(this.statusCode, this.response, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSalesforceResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSalesforceResponse
        && equalTo((ImmutableSalesforceResponse) another);
  }

  private boolean equalTo(ImmutableSalesforceResponse another) {
    return statusCode == another.statusCode
        && Objects.equal(response, another.response)
        && errorReason.equals(another.errorReason);
  }

  /**
   * Computes a hash code from attributes: {@code statusCode}, {@code response}, {@code errorReason}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + statusCode;
    h = h * 17 + Objects.hashCode(response);
    h = h * 17 + errorReason.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code SalesforceResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("SalesforceResponse")
        .omitNullValues()
        .add("statusCode", statusCode)
        .add("response", response)
        .add("errorReason", errorReason)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link SalesforceResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable SalesforceResponse instance
   */
  public static ImmutableSalesforceResponse copyOf(SalesforceResponse instance) {
    if (instance instanceof ImmutableSalesforceResponse) {
      return (ImmutableSalesforceResponse) instance;
    }
    return ImmutableSalesforceResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSalesforceResponse ImmutableSalesforceResponse}.
   * @return A new ImmutableSalesforceResponse builder
   */
  public static ImmutableSalesforceResponse.Builder builder() {
    return new ImmutableSalesforceResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSalesforceResponse ImmutableSalesforceResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_STATUS_CODE = 0x1L;
    private static final long INIT_BIT_ERROR_REASON = 0x2L;
    private long initBits = 0x3L;

    private int statusCode;
    private @Nullable String response;
    private @Nullable String errorReason;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code SalesforceResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(SalesforceResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      statusCode(instance.statusCode());
      @Nullable String responseValue = instance.response();
      if (responseValue != null) {
        response(responseValue);
      }
      errorReason(instance.errorReason());
      return this;
    }

    /**
     * Initializes the value for the {@link SalesforceResponse#statusCode() statusCode} attribute.
     * @param statusCode The value for statusCode 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder statusCode(int statusCode) {
      this.statusCode = statusCode;
      initBits &= ~INIT_BIT_STATUS_CODE;
      return this;
    }

    /**
     * Initializes the value for the {@link SalesforceResponse#response() response} attribute.
     * @param response The value for response (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder response(@Nullable String response) {
      this.response = response;
      return this;
    }

    /**
     * Initializes the value for the {@link SalesforceResponse#errorReason() errorReason} attribute.
     * @param errorReason The value for errorReason 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorReason(String errorReason) {
      this.errorReason = Preconditions.checkNotNull(errorReason, "errorReason");
      initBits &= ~INIT_BIT_ERROR_REASON;
      return this;
    }

    /**
     * Builds a new {@link ImmutableSalesforceResponse ImmutableSalesforceResponse}.
     * @return An immutable instance of SalesforceResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSalesforceResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSalesforceResponse(statusCode, response, errorReason);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_STATUS_CODE) != 0) attributes.add("statusCode");
      if ((initBits & INIT_BIT_ERROR_REASON) != 0) attributes.add("errorReason");
      return "Cannot build SalesforceResponse, some of required attributes are not set " + attributes;
    }
  }
}
