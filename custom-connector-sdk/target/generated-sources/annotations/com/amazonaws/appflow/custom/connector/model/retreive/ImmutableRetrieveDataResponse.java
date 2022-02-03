package com.amazonaws.appflow.custom.connector.model.retreive;

import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link RetrieveDataResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRetrieveDataResponse.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableRetrieveDataResponse
    implements RetrieveDataResponse {
  private final boolean isSuccess;
  private final @Nullable ErrorDetails errorDetails;
  private final @Nullable ImmutableList<String> records;

  private ImmutableRetrieveDataResponse(
      boolean isSuccess,
      @Nullable ErrorDetails errorDetails,
      @Nullable ImmutableList<String> records) {
    this.isSuccess = isSuccess;
    this.errorDetails = errorDetails;
    this.records = records;
  }

  /**
   * Specifies if the operation is successful or not.
   */
  @JsonProperty("isSuccess")
  @Override
  public boolean isSuccess() {
    return isSuccess;
  }

  /**
   * Error details if the Operation is unsuccessful.
   */
  @JsonProperty("errorDetails")
  @Override
  public @Nullable ErrorDetails errorDetails() {
    return errorDetails;
  }

  /**
   * List of json serialized string of the entity record as per the entity metadata.
   */
  @JsonProperty("records")
  @Override
  public @Nullable ImmutableList<String> records() {
    return records;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RetrieveDataResponse#isSuccess() isSuccess} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param isSuccess A new value for isSuccess
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRetrieveDataResponse withIsSuccess(boolean isSuccess) {
    if (this.isSuccess == isSuccess) return this;
    return new ImmutableRetrieveDataResponse(isSuccess, this.errorDetails, this.records);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RetrieveDataResponse#errorDetails() errorDetails} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorDetails A new value for errorDetails (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRetrieveDataResponse withErrorDetails(@Nullable ErrorDetails errorDetails) {
    if (this.errorDetails == errorDetails) return this;
    return new ImmutableRetrieveDataResponse(this.isSuccess, errorDetails, this.records);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RetrieveDataResponse#records() records}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRetrieveDataResponse withRecords(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableRetrieveDataResponse(this.isSuccess, this.errorDetails, null);
    }
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableRetrieveDataResponse(this.isSuccess, this.errorDetails, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RetrieveDataResponse#records() records}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of records elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRetrieveDataResponse withRecords(@Nullable Iterable<String> elements) {
    if (this.records == elements) return this;
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableRetrieveDataResponse(this.isSuccess, this.errorDetails, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRetrieveDataResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRetrieveDataResponse
        && equalTo((ImmutableRetrieveDataResponse) another);
  }

  private boolean equalTo(ImmutableRetrieveDataResponse another) {
    return isSuccess == another.isSuccess
        && Objects.equal(errorDetails, another.errorDetails)
        && Objects.equal(records, another.records);
  }

  /**
   * Computes a hash code from attributes: {@code isSuccess}, {@code errorDetails}, {@code records}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Booleans.hashCode(isSuccess);
    h = h * 17 + Objects.hashCode(errorDetails);
    h = h * 17 + Objects.hashCode(records);
    return h;
  }

  /**
   * Prints the immutable value {@code RetrieveDataResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("RetrieveDataResponse")
        .omitNullValues()
        .add("isSuccess", isSuccess)
        .add("errorDetails", errorDetails)
        .add("records", records)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements RetrieveDataResponse {
    boolean isSuccess;
    boolean isSuccessIsSet;
    @Nullable ErrorDetails errorDetails;
    List<String> records = null;
    @JsonProperty("isSuccess")
    public void setIsSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      this.isSuccessIsSet = true;
    }
    @JsonProperty("errorDetails")
    public void setErrorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
    }
    @JsonProperty("records")
    public void setRecords(@Nullable List<String> records) {
      this.records = records;
    }
    @Override
    public boolean isSuccess() { throw new UnsupportedOperationException(); }
    @Override
    public ErrorDetails errorDetails() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> records() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableRetrieveDataResponse fromJson(Json json) {
    ImmutableRetrieveDataResponse.Builder builder = ImmutableRetrieveDataResponse.builder();
    if (json.isSuccessIsSet) {
      builder.isSuccess(json.isSuccess);
    }
    if (json.errorDetails != null) {
      builder.errorDetails(json.errorDetails);
    }
    if (json.records != null) {
      builder.addAllRecords(json.records);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link RetrieveDataResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RetrieveDataResponse instance
   */
  public static ImmutableRetrieveDataResponse copyOf(RetrieveDataResponse instance) {
    if (instance instanceof ImmutableRetrieveDataResponse) {
      return (ImmutableRetrieveDataResponse) instance;
    }
    return ImmutableRetrieveDataResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableRetrieveDataResponse ImmutableRetrieveDataResponse}.
   * @return A new ImmutableRetrieveDataResponse builder
   */
  public static ImmutableRetrieveDataResponse.Builder builder() {
    return new ImmutableRetrieveDataResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableRetrieveDataResponse ImmutableRetrieveDataResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_IS_SUCCESS = 0x1L;
    private long initBits = 0x1L;

    private boolean isSuccess;
    private @Nullable ErrorDetails errorDetails;
    private ImmutableList.Builder<String> records = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code RetrieveDataResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(RetrieveDataResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      isSuccess(instance.isSuccess());
      @Nullable ErrorDetails errorDetailsValue = instance.errorDetails();
      if (errorDetailsValue != null) {
        errorDetails(errorDetailsValue);
      }
      @Nullable List<String> recordsValue = instance.records();
      if (recordsValue != null) {
        addAllRecords(recordsValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link RetrieveDataResponse#isSuccess() isSuccess} attribute.
     * @param isSuccess The value for isSuccess 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      initBits &= ~INIT_BIT_IS_SUCCESS;
      return this;
    }

    /**
     * Initializes the value for the {@link RetrieveDataResponse#errorDetails() errorDetails} attribute.
     * @param errorDetails The value for errorDetails (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
      return this;
    }

    /**
     * Adds one element to {@link RetrieveDataResponse#records() records} list.
     * @param element A records element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addRecords(String element) {
      if (this.records == null) {
        this.records = ImmutableList.builder();
      }
      this.records.add(element);
      return this;
    }

    /**
     * Adds elements to {@link RetrieveDataResponse#records() records} list.
     * @param elements An array of records elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addRecords(String... elements) {
      if (this.records == null) {
        this.records = ImmutableList.builder();
      }
      this.records.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link RetrieveDataResponse#records() records} list.
     * @param elements An iterable of records elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder records(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.records = null;
        return this;
      }
      this.records = ImmutableList.builder();
      return addAllRecords(elements);
    }

    /**
     * Adds elements to {@link RetrieveDataResponse#records() records} list.
     * @param elements An iterable of records elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllRecords(Iterable<String> elements) {
      Preconditions.checkNotNull(elements, "records element");
      if (this.records == null) {
        this.records = ImmutableList.builder();
      }
      this.records.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableRetrieveDataResponse ImmutableRetrieveDataResponse}.
     * @return An immutable instance of RetrieveDataResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableRetrieveDataResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableRetrieveDataResponse(isSuccess, errorDetails, records == null ? null : records.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_IS_SUCCESS) != 0) attributes.add("isSuccess");
      return "Cannot build RetrieveDataResponse, some of required attributes are not set " + attributes;
    }
  }
}
