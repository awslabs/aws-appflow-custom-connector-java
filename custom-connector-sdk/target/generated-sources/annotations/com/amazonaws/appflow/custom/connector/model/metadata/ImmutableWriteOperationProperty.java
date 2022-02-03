package com.amazonaws.appflow.custom.connector.model.metadata;

import com.amazonaws.appflow.custom.connector.model.write.WriteOperationType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link WriteOperationProperty}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableWriteOperationProperty.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableWriteOperationProperty
    implements WriteOperationProperty {
  private final @Nullable Boolean isCreatable;
  private final @Nullable Boolean isUpdatable;
  private final @Nullable Boolean isNullable;
  private final @Nullable Boolean isUpsertable;
  private final @Nullable Boolean isDefaultedOnCreate;
  private final @Nullable ImmutableList<WriteOperationType> supportedWriteOperations;

  private ImmutableWriteOperationProperty(
      @Nullable Boolean isCreatable,
      @Nullable Boolean isUpdatable,
      @Nullable Boolean isNullable,
      @Nullable Boolean isUpsertable,
      @Nullable Boolean isDefaultedOnCreate,
      @Nullable ImmutableList<WriteOperationType> supportedWriteOperations) {
    this.isCreatable = isCreatable;
    this.isUpdatable = isUpdatable;
    this.isNullable = isNullable;
    this.isUpsertable = isUpsertable;
    this.isDefaultedOnCreate = isDefaultedOnCreate;
    this.supportedWriteOperations = supportedWriteOperations;
  }

  /**
   * Specifies if the destination field can be created by the current user.
   */
  @JsonProperty("isCreatable")
  @Override
  public @Nullable Boolean isCreatable() {
    return isCreatable;
  }

  /**
   * Specifies whether the field can be updated during an UPDATE or UPSERT write operation.
   */
  @JsonProperty("isUpdatable")
  @Override
  public @Nullable Boolean isUpdatable() {
    return isUpdatable;
  }

  /**
   * Specifies if the destination field can have a null value.
   */
  @JsonProperty("isNullable")
  @Override
  public @Nullable Boolean isNullable() {
    return isNullable;
  }

  /**
   * Specifies if the flow run can either insert new rows in the destination field if they do not already exist, or
   * update them if they do.
   */
  @JsonProperty("isUpsertable")
  @Override
  public @Nullable Boolean isUpsertable() {
    return isUpsertable;
  }

  /**
   * Specifies if default value will be used by application while creating records if not provided.
   */
  @JsonProperty("isDefaultedOnCreate")
  @Override
  public @Nullable Boolean isDefaultedOnCreate() {
    return isDefaultedOnCreate;
  }

  /**
   * A list of supported write operations. For each write operation listed, this field can be used in idFieldNames
   * when that write operation is present as a destination option.
   */
  @JsonProperty("supportedWriteOperations")
  @Override
  public @Nullable ImmutableList<WriteOperationType> supportedWriteOperations() {
    return supportedWriteOperations;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteOperationProperty#isCreatable() isCreatable} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isCreatable A new value for isCreatable (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteOperationProperty withIsCreatable(@Nullable Boolean isCreatable) {
    if (Objects.equal(this.isCreatable, isCreatable)) return this;
    return new ImmutableWriteOperationProperty(
        isCreatable,
        this.isUpdatable,
        this.isNullable,
        this.isUpsertable,
        this.isDefaultedOnCreate,
        this.supportedWriteOperations);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteOperationProperty#isUpdatable() isUpdatable} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isUpdatable A new value for isUpdatable (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteOperationProperty withIsUpdatable(@Nullable Boolean isUpdatable) {
    if (Objects.equal(this.isUpdatable, isUpdatable)) return this;
    return new ImmutableWriteOperationProperty(
        this.isCreatable,
        isUpdatable,
        this.isNullable,
        this.isUpsertable,
        this.isDefaultedOnCreate,
        this.supportedWriteOperations);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteOperationProperty#isNullable() isNullable} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isNullable A new value for isNullable (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteOperationProperty withIsNullable(@Nullable Boolean isNullable) {
    if (Objects.equal(this.isNullable, isNullable)) return this;
    return new ImmutableWriteOperationProperty(
        this.isCreatable,
        this.isUpdatable,
        isNullable,
        this.isUpsertable,
        this.isDefaultedOnCreate,
        this.supportedWriteOperations);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteOperationProperty#isUpsertable() isUpsertable} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isUpsertable A new value for isUpsertable (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteOperationProperty withIsUpsertable(@Nullable Boolean isUpsertable) {
    if (Objects.equal(this.isUpsertable, isUpsertable)) return this;
    return new ImmutableWriteOperationProperty(
        this.isCreatable,
        this.isUpdatable,
        this.isNullable,
        isUpsertable,
        this.isDefaultedOnCreate,
        this.supportedWriteOperations);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteOperationProperty#isDefaultedOnCreate() isDefaultedOnCreate} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isDefaultedOnCreate A new value for isDefaultedOnCreate (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteOperationProperty withIsDefaultedOnCreate(@Nullable Boolean isDefaultedOnCreate) {
    if (Objects.equal(this.isDefaultedOnCreate, isDefaultedOnCreate)) return this;
    return new ImmutableWriteOperationProperty(
        this.isCreatable,
        this.isUpdatable,
        this.isNullable,
        this.isUpsertable,
        isDefaultedOnCreate,
        this.supportedWriteOperations);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link WriteOperationProperty#supportedWriteOperations() supportedWriteOperations}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableWriteOperationProperty withSupportedWriteOperations(@Nullable WriteOperationType... elements) {
    if (elements == null) {
      return new ImmutableWriteOperationProperty(
          this.isCreatable,
          this.isUpdatable,
          this.isNullable,
          this.isUpsertable,
          this.isDefaultedOnCreate,
          null);
    }
    @Nullable ImmutableList<WriteOperationType> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableWriteOperationProperty(
        this.isCreatable,
        this.isUpdatable,
        this.isNullable,
        this.isUpsertable,
        this.isDefaultedOnCreate,
        newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link WriteOperationProperty#supportedWriteOperations() supportedWriteOperations}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of supportedWriteOperations elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableWriteOperationProperty withSupportedWriteOperations(@Nullable Iterable<? extends WriteOperationType> elements) {
    if (this.supportedWriteOperations == elements) return this;
    @Nullable ImmutableList<WriteOperationType> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableWriteOperationProperty(
        this.isCreatable,
        this.isUpdatable,
        this.isNullable,
        this.isUpsertable,
        this.isDefaultedOnCreate,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableWriteOperationProperty} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableWriteOperationProperty
        && equalTo((ImmutableWriteOperationProperty) another);
  }

  private boolean equalTo(ImmutableWriteOperationProperty another) {
    return Objects.equal(isCreatable, another.isCreatable)
        && Objects.equal(isUpdatable, another.isUpdatable)
        && Objects.equal(isNullable, another.isNullable)
        && Objects.equal(isUpsertable, another.isUpsertable)
        && Objects.equal(isDefaultedOnCreate, another.isDefaultedOnCreate)
        && Objects.equal(supportedWriteOperations, another.supportedWriteOperations);
  }

  /**
   * Computes a hash code from attributes: {@code isCreatable}, {@code isUpdatable}, {@code isNullable}, {@code isUpsertable}, {@code isDefaultedOnCreate}, {@code supportedWriteOperations}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(isCreatable);
    h = h * 17 + Objects.hashCode(isUpdatable);
    h = h * 17 + Objects.hashCode(isNullable);
    h = h * 17 + Objects.hashCode(isUpsertable);
    h = h * 17 + Objects.hashCode(isDefaultedOnCreate);
    h = h * 17 + Objects.hashCode(supportedWriteOperations);
    return h;
  }

  /**
   * Prints the immutable value {@code WriteOperationProperty} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("WriteOperationProperty")
        .omitNullValues()
        .add("isCreatable", isCreatable)
        .add("isUpdatable", isUpdatable)
        .add("isNullable", isNullable)
        .add("isUpsertable", isUpsertable)
        .add("isDefaultedOnCreate", isDefaultedOnCreate)
        .add("supportedWriteOperations", supportedWriteOperations)
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
      implements WriteOperationProperty {
    @Nullable Boolean isCreatable;
    @Nullable Boolean isUpdatable;
    @Nullable Boolean isNullable;
    @Nullable Boolean isUpsertable;
    @Nullable Boolean isDefaultedOnCreate;
    List<WriteOperationType> supportedWriteOperations = null;
    @JsonProperty("isCreatable")
    public void setIsCreatable(@Nullable Boolean isCreatable) {
      this.isCreatable = isCreatable;
    }
    @JsonProperty("isUpdatable")
    public void setIsUpdatable(@Nullable Boolean isUpdatable) {
      this.isUpdatable = isUpdatable;
    }
    @JsonProperty("isNullable")
    public void setIsNullable(@Nullable Boolean isNullable) {
      this.isNullable = isNullable;
    }
    @JsonProperty("isUpsertable")
    public void setIsUpsertable(@Nullable Boolean isUpsertable) {
      this.isUpsertable = isUpsertable;
    }
    @JsonProperty("isDefaultedOnCreate")
    public void setIsDefaultedOnCreate(@Nullable Boolean isDefaultedOnCreate) {
      this.isDefaultedOnCreate = isDefaultedOnCreate;
    }
    @JsonProperty("supportedWriteOperations")
    public void setSupportedWriteOperations(@Nullable List<WriteOperationType> supportedWriteOperations) {
      this.supportedWriteOperations = supportedWriteOperations;
    }
    @Override
    public Boolean isCreatable() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isUpdatable() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isNullable() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isUpsertable() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isDefaultedOnCreate() { throw new UnsupportedOperationException(); }
    @Override
    public List<WriteOperationType> supportedWriteOperations() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableWriteOperationProperty fromJson(Json json) {
    ImmutableWriteOperationProperty.Builder builder = ImmutableWriteOperationProperty.builder();
    if (json.isCreatable != null) {
      builder.isCreatable(json.isCreatable);
    }
    if (json.isUpdatable != null) {
      builder.isUpdatable(json.isUpdatable);
    }
    if (json.isNullable != null) {
      builder.isNullable(json.isNullable);
    }
    if (json.isUpsertable != null) {
      builder.isUpsertable(json.isUpsertable);
    }
    if (json.isDefaultedOnCreate != null) {
      builder.isDefaultedOnCreate(json.isDefaultedOnCreate);
    }
    if (json.supportedWriteOperations != null) {
      builder.addAllSupportedWriteOperations(json.supportedWriteOperations);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link WriteOperationProperty} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable WriteOperationProperty instance
   */
  public static ImmutableWriteOperationProperty copyOf(WriteOperationProperty instance) {
    if (instance instanceof ImmutableWriteOperationProperty) {
      return (ImmutableWriteOperationProperty) instance;
    }
    return ImmutableWriteOperationProperty.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableWriteOperationProperty ImmutableWriteOperationProperty}.
   * @return A new ImmutableWriteOperationProperty builder
   */
  public static ImmutableWriteOperationProperty.Builder builder() {
    return new ImmutableWriteOperationProperty.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableWriteOperationProperty ImmutableWriteOperationProperty}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable Boolean isCreatable;
    private @Nullable Boolean isUpdatable;
    private @Nullable Boolean isNullable;
    private @Nullable Boolean isUpsertable;
    private @Nullable Boolean isDefaultedOnCreate;
    private ImmutableList.Builder<WriteOperationType> supportedWriteOperations = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code WriteOperationProperty} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(WriteOperationProperty instance) {
      Preconditions.checkNotNull(instance, "instance");
      @Nullable Boolean isCreatableValue = instance.isCreatable();
      if (isCreatableValue != null) {
        isCreatable(isCreatableValue);
      }
      @Nullable Boolean isUpdatableValue = instance.isUpdatable();
      if (isUpdatableValue != null) {
        isUpdatable(isUpdatableValue);
      }
      @Nullable Boolean isNullableValue = instance.isNullable();
      if (isNullableValue != null) {
        isNullable(isNullableValue);
      }
      @Nullable Boolean isUpsertableValue = instance.isUpsertable();
      if (isUpsertableValue != null) {
        isUpsertable(isUpsertableValue);
      }
      @Nullable Boolean isDefaultedOnCreateValue = instance.isDefaultedOnCreate();
      if (isDefaultedOnCreateValue != null) {
        isDefaultedOnCreate(isDefaultedOnCreateValue);
      }
      @Nullable List<WriteOperationType> supportedWriteOperationsValue = instance.supportedWriteOperations();
      if (supportedWriteOperationsValue != null) {
        addAllSupportedWriteOperations(supportedWriteOperationsValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link WriteOperationProperty#isCreatable() isCreatable} attribute.
     * @param isCreatable The value for isCreatable (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isCreatable(@Nullable Boolean isCreatable) {
      this.isCreatable = isCreatable;
      return this;
    }

    /**
     * Initializes the value for the {@link WriteOperationProperty#isUpdatable() isUpdatable} attribute.
     * @param isUpdatable The value for isUpdatable (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isUpdatable(@Nullable Boolean isUpdatable) {
      this.isUpdatable = isUpdatable;
      return this;
    }

    /**
     * Initializes the value for the {@link WriteOperationProperty#isNullable() isNullable} attribute.
     * @param isNullable The value for isNullable (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isNullable(@Nullable Boolean isNullable) {
      this.isNullable = isNullable;
      return this;
    }

    /**
     * Initializes the value for the {@link WriteOperationProperty#isUpsertable() isUpsertable} attribute.
     * @param isUpsertable The value for isUpsertable (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isUpsertable(@Nullable Boolean isUpsertable) {
      this.isUpsertable = isUpsertable;
      return this;
    }

    /**
     * Initializes the value for the {@link WriteOperationProperty#isDefaultedOnCreate() isDefaultedOnCreate} attribute.
     * @param isDefaultedOnCreate The value for isDefaultedOnCreate (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isDefaultedOnCreate(@Nullable Boolean isDefaultedOnCreate) {
      this.isDefaultedOnCreate = isDefaultedOnCreate;
      return this;
    }

    /**
     * Adds one element to {@link WriteOperationProperty#supportedWriteOperations() supportedWriteOperations} list.
     * @param element A supportedWriteOperations element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupportedWriteOperations(WriteOperationType element) {
      if (this.supportedWriteOperations == null) {
        this.supportedWriteOperations = ImmutableList.builder();
      }
      this.supportedWriteOperations.add(element);
      return this;
    }

    /**
     * Adds elements to {@link WriteOperationProperty#supportedWriteOperations() supportedWriteOperations} list.
     * @param elements An array of supportedWriteOperations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupportedWriteOperations(WriteOperationType... elements) {
      if (this.supportedWriteOperations == null) {
        this.supportedWriteOperations = ImmutableList.builder();
      }
      this.supportedWriteOperations.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link WriteOperationProperty#supportedWriteOperations() supportedWriteOperations} list.
     * @param elements An iterable of supportedWriteOperations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder supportedWriteOperations(@Nullable Iterable<? extends WriteOperationType> elements) {
      if (elements == null) {
        this.supportedWriteOperations = null;
        return this;
      }
      this.supportedWriteOperations = ImmutableList.builder();
      return addAllSupportedWriteOperations(elements);
    }

    /**
     * Adds elements to {@link WriteOperationProperty#supportedWriteOperations() supportedWriteOperations} list.
     * @param elements An iterable of supportedWriteOperations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSupportedWriteOperations(Iterable<? extends WriteOperationType> elements) {
      Preconditions.checkNotNull(elements, "supportedWriteOperations element");
      if (this.supportedWriteOperations == null) {
        this.supportedWriteOperations = ImmutableList.builder();
      }
      this.supportedWriteOperations.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableWriteOperationProperty ImmutableWriteOperationProperty}.
     * @return An immutable instance of WriteOperationProperty
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableWriteOperationProperty build() {
      return new ImmutableWriteOperationProperty(
          isCreatable,
          isUpdatable,
          isNullable,
          isUpsertable,
          isDefaultedOnCreate,
          supportedWriteOperations == null ? null : supportedWriteOperations.build());
    }
  }
}
