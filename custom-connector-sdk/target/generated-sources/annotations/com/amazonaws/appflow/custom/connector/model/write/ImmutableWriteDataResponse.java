package com.amazonaws.appflow.custom.connector.model.write;

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
 * Immutable implementation of {@link WriteDataResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableWriteDataResponse.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableWriteDataResponse
    implements WriteDataResponse {
  private final boolean isSuccess;
  private final @Nullable ErrorDetails errorDetails;
  private final @Nullable ImmutableList<WriteRecordResult> writeRecordResults;

  private ImmutableWriteDataResponse(
      boolean isSuccess,
      @Nullable ErrorDetails errorDetails,
      @Nullable ImmutableList<WriteRecordResult> writeRecordResults) {
    this.isSuccess = isSuccess;
    this.errorDetails = errorDetails;
    this.writeRecordResults = writeRecordResults;
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
   * List of input records write call response with success and failure details.
   */
  @JsonProperty("writeRecordResults")
  @Override
  public @Nullable ImmutableList<WriteRecordResult> writeRecordResults() {
    return writeRecordResults;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteDataResponse#isSuccess() isSuccess} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param isSuccess A new value for isSuccess
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteDataResponse withIsSuccess(boolean isSuccess) {
    if (this.isSuccess == isSuccess) return this;
    return new ImmutableWriteDataResponse(isSuccess, this.errorDetails, this.writeRecordResults);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteDataResponse#errorDetails() errorDetails} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorDetails A new value for errorDetails (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteDataResponse withErrorDetails(@Nullable ErrorDetails errorDetails) {
    if (this.errorDetails == errorDetails) return this;
    return new ImmutableWriteDataResponse(this.isSuccess, errorDetails, this.writeRecordResults);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link WriteDataResponse#writeRecordResults() writeRecordResults}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableWriteDataResponse withWriteRecordResults(@Nullable WriteRecordResult... elements) {
    if (elements == null) {
      return new ImmutableWriteDataResponse(this.isSuccess, this.errorDetails, null);
    }
    @Nullable ImmutableList<WriteRecordResult> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableWriteDataResponse(this.isSuccess, this.errorDetails, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link WriteDataResponse#writeRecordResults() writeRecordResults}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of writeRecordResults elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableWriteDataResponse withWriteRecordResults(@Nullable Iterable<? extends WriteRecordResult> elements) {
    if (this.writeRecordResults == elements) return this;
    @Nullable ImmutableList<WriteRecordResult> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableWriteDataResponse(this.isSuccess, this.errorDetails, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableWriteDataResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableWriteDataResponse
        && equalTo((ImmutableWriteDataResponse) another);
  }

  private boolean equalTo(ImmutableWriteDataResponse another) {
    return isSuccess == another.isSuccess
        && Objects.equal(errorDetails, another.errorDetails)
        && Objects.equal(writeRecordResults, another.writeRecordResults);
  }

  /**
   * Computes a hash code from attributes: {@code isSuccess}, {@code errorDetails}, {@code writeRecordResults}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Booleans.hashCode(isSuccess);
    h = h * 17 + Objects.hashCode(errorDetails);
    h = h * 17 + Objects.hashCode(writeRecordResults);
    return h;
  }

  /**
   * Prints the immutable value {@code WriteDataResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("WriteDataResponse")
        .omitNullValues()
        .add("isSuccess", isSuccess)
        .add("errorDetails", errorDetails)
        .add("writeRecordResults", writeRecordResults)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements WriteDataResponse {
    boolean isSuccess;
    boolean isSuccessIsSet;
    @Nullable ErrorDetails errorDetails;
    List<WriteRecordResult> writeRecordResults = null;
    @JsonProperty("isSuccess")
    public void setIsSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      this.isSuccessIsSet = true;
    }
    @JsonProperty("errorDetails")
    public void setErrorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
    }
    @JsonProperty("writeRecordResults")
    public void setWriteRecordResults(@Nullable List<WriteRecordResult> writeRecordResults) {
      this.writeRecordResults = writeRecordResults;
    }
    @Override
    public boolean isSuccess() { throw new UnsupportedOperationException(); }
    @Override
    public ErrorDetails errorDetails() { throw new UnsupportedOperationException(); }
    @Override
    public List<WriteRecordResult> writeRecordResults() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableWriteDataResponse fromJson(Json json) {
    ImmutableWriteDataResponse.Builder builder = ImmutableWriteDataResponse.builder();
    if (json.isSuccessIsSet) {
      builder.isSuccess(json.isSuccess);
    }
    if (json.errorDetails != null) {
      builder.errorDetails(json.errorDetails);
    }
    if (json.writeRecordResults != null) {
      builder.addAllWriteRecordResults(json.writeRecordResults);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link WriteDataResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable WriteDataResponse instance
   */
  public static ImmutableWriteDataResponse copyOf(WriteDataResponse instance) {
    if (instance instanceof ImmutableWriteDataResponse) {
      return (ImmutableWriteDataResponse) instance;
    }
    return ImmutableWriteDataResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableWriteDataResponse ImmutableWriteDataResponse}.
   * @return A new ImmutableWriteDataResponse builder
   */
  public static ImmutableWriteDataResponse.Builder builder() {
    return new ImmutableWriteDataResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableWriteDataResponse ImmutableWriteDataResponse}.
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
    private ImmutableList.Builder<WriteRecordResult> writeRecordResults = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code WriteDataResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(WriteDataResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      isSuccess(instance.isSuccess());
      @Nullable ErrorDetails errorDetailsValue = instance.errorDetails();
      if (errorDetailsValue != null) {
        errorDetails(errorDetailsValue);
      }
      @Nullable List<WriteRecordResult> writeRecordResultsValue = instance.writeRecordResults();
      if (writeRecordResultsValue != null) {
        addAllWriteRecordResults(writeRecordResultsValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link WriteDataResponse#isSuccess() isSuccess} attribute.
     * @param isSuccess The value for isSuccess 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      initBits &= ~INIT_BIT_IS_SUCCESS;
      return this;
    }

    /**
     * Initializes the value for the {@link WriteDataResponse#errorDetails() errorDetails} attribute.
     * @param errorDetails The value for errorDetails (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
      return this;
    }

    /**
     * Adds one element to {@link WriteDataResponse#writeRecordResults() writeRecordResults} list.
     * @param element A writeRecordResults element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addWriteRecordResults(WriteRecordResult element) {
      if (this.writeRecordResults == null) {
        this.writeRecordResults = ImmutableList.builder();
      }
      this.writeRecordResults.add(element);
      return this;
    }

    /**
     * Adds elements to {@link WriteDataResponse#writeRecordResults() writeRecordResults} list.
     * @param elements An array of writeRecordResults elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addWriteRecordResults(WriteRecordResult... elements) {
      if (this.writeRecordResults == null) {
        this.writeRecordResults = ImmutableList.builder();
      }
      this.writeRecordResults.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link WriteDataResponse#writeRecordResults() writeRecordResults} list.
     * @param elements An iterable of writeRecordResults elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder writeRecordResults(@Nullable Iterable<? extends WriteRecordResult> elements) {
      if (elements == null) {
        this.writeRecordResults = null;
        return this;
      }
      this.writeRecordResults = ImmutableList.builder();
      return addAllWriteRecordResults(elements);
    }

    /**
     * Adds elements to {@link WriteDataResponse#writeRecordResults() writeRecordResults} list.
     * @param elements An iterable of writeRecordResults elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllWriteRecordResults(Iterable<? extends WriteRecordResult> elements) {
      Preconditions.checkNotNull(elements, "writeRecordResults element");
      if (this.writeRecordResults == null) {
        this.writeRecordResults = ImmutableList.builder();
      }
      this.writeRecordResults.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableWriteDataResponse ImmutableWriteDataResponse}.
     * @return An immutable instance of WriteDataResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableWriteDataResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableWriteDataResponse(isSuccess, errorDetails, writeRecordResults == null ? null : writeRecordResults.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_IS_SUCCESS) != 0) attributes.add("isSuccess");
      return "Cannot build WriteDataResponse, some of required attributes are not set " + attributes;
    }
  }
}
