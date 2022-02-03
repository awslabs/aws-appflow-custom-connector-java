package com.amazonaws.appflow.custom.connector.model.metadata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link Entity}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEntity.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableEntity implements Entity {
  private final String entityIdentifier;
  private final boolean hasNestedEntities;
  private final @Nullable String label;
  private final @Nullable String description;

  private ImmutableEntity(
      String entityIdentifier,
      boolean hasNestedEntities,
      @Nullable String label,
      @Nullable String description) {
    this.entityIdentifier = entityIdentifier;
    this.hasNestedEntities = hasNestedEntities;
    this.label = label;
    this.description = description;
  }

  /**
   * Unique identifier for the entity. Can be entityId/ entityName / entityPath+name / entityUrl etc.
   */
  @JsonProperty("entityIdentifier")
  @Override
  public String entityIdentifier() {
    return entityIdentifier;
  }

  /**
   * Specifies whether the connector entity is a parent or a category and has more entities nested underneath it.
   */
  @JsonProperty("hasNestedEntities")
  @Override
  public boolean hasNestedEntities() {
    return hasNestedEntities;
  }

  /**
   * Label of the entity.
   */
  @JsonProperty("label")
  @Override
  public @Nullable String label() {
    return label;
  }

  /**
   * Description of the entity.
   */
  @JsonProperty("description")
  @Override
  public @Nullable String description() {
    return description;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Entity#entityIdentifier() entityIdentifier} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param entityIdentifier A new value for entityIdentifier
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEntity withEntityIdentifier(String entityIdentifier) {
    if (this.entityIdentifier.equals(entityIdentifier)) return this;
    String newValue = Preconditions.checkNotNull(entityIdentifier, "entityIdentifier");
    return new ImmutableEntity(newValue, this.hasNestedEntities, this.label, this.description);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Entity#hasNestedEntities() hasNestedEntities} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param hasNestedEntities A new value for hasNestedEntities
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEntity withHasNestedEntities(boolean hasNestedEntities) {
    if (this.hasNestedEntities == hasNestedEntities) return this;
    return new ImmutableEntity(this.entityIdentifier, hasNestedEntities, this.label, this.description);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Entity#label() label} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param label A new value for label (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEntity withLabel(@Nullable String label) {
    if (Objects.equal(this.label, label)) return this;
    return new ImmutableEntity(this.entityIdentifier, this.hasNestedEntities, label, this.description);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Entity#description() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param description A new value for description (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEntity withDescription(@Nullable String description) {
    if (Objects.equal(this.description, description)) return this;
    return new ImmutableEntity(this.entityIdentifier, this.hasNestedEntities, this.label, description);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEntity} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEntity
        && equalTo((ImmutableEntity) another);
  }

  private boolean equalTo(ImmutableEntity another) {
    return entityIdentifier.equals(another.entityIdentifier)
        && hasNestedEntities == another.hasNestedEntities
        && Objects.equal(label, another.label)
        && Objects.equal(description, another.description);
  }

  /**
   * Computes a hash code from attributes: {@code entityIdentifier}, {@code hasNestedEntities}, {@code label}, {@code description}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + entityIdentifier.hashCode();
    h = h * 17 + Booleans.hashCode(hasNestedEntities);
    h = h * 17 + Objects.hashCode(label);
    h = h * 17 + Objects.hashCode(description);
    return h;
  }

  /**
   * Prints the immutable value {@code Entity} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Entity")
        .omitNullValues()
        .add("entityIdentifier", entityIdentifier)
        .add("hasNestedEntities", hasNestedEntities)
        .add("label", label)
        .add("description", description)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Entity {
    @Nullable String entityIdentifier;
    boolean hasNestedEntities;
    boolean hasNestedEntitiesIsSet;
    @Nullable String label;
    @Nullable String description;
    @JsonProperty("entityIdentifier")
    public void setEntityIdentifier(String entityIdentifier) {
      this.entityIdentifier = entityIdentifier;
    }
    @JsonProperty("hasNestedEntities")
    public void setHasNestedEntities(boolean hasNestedEntities) {
      this.hasNestedEntities = hasNestedEntities;
      this.hasNestedEntitiesIsSet = true;
    }
    @JsonProperty("label")
    public void setLabel(@Nullable String label) {
      this.label = label;
    }
    @JsonProperty("description")
    public void setDescription(@Nullable String description) {
      this.description = description;
    }
    @Override
    public String entityIdentifier() { throw new UnsupportedOperationException(); }
    @Override
    public boolean hasNestedEntities() { throw new UnsupportedOperationException(); }
    @Override
    public String label() { throw new UnsupportedOperationException(); }
    @Override
    public String description() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableEntity fromJson(Json json) {
    ImmutableEntity.Builder builder = ImmutableEntity.builder();
    if (json.entityIdentifier != null) {
      builder.entityIdentifier(json.entityIdentifier);
    }
    if (json.hasNestedEntitiesIsSet) {
      builder.hasNestedEntities(json.hasNestedEntities);
    }
    if (json.label != null) {
      builder.label(json.label);
    }
    if (json.description != null) {
      builder.description(json.description);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Entity} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Entity instance
   */
  public static ImmutableEntity copyOf(Entity instance) {
    if (instance instanceof ImmutableEntity) {
      return (ImmutableEntity) instance;
    }
    return ImmutableEntity.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEntity ImmutableEntity}.
   * @return A new ImmutableEntity builder
   */
  public static ImmutableEntity.Builder builder() {
    return new ImmutableEntity.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEntity ImmutableEntity}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ENTITY_IDENTIFIER = 0x1L;
    private static final long INIT_BIT_HAS_NESTED_ENTITIES = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String entityIdentifier;
    private boolean hasNestedEntities;
    private @Nullable String label;
    private @Nullable String description;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Entity} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Entity instance) {
      Preconditions.checkNotNull(instance, "instance");
      entityIdentifier(instance.entityIdentifier());
      hasNestedEntities(instance.hasNestedEntities());
      @Nullable String labelValue = instance.label();
      if (labelValue != null) {
        label(labelValue);
      }
      @Nullable String descriptionValue = instance.description();
      if (descriptionValue != null) {
        description(descriptionValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link Entity#entityIdentifier() entityIdentifier} attribute.
     * @param entityIdentifier The value for entityIdentifier 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityIdentifier(String entityIdentifier) {
      this.entityIdentifier = Preconditions.checkNotNull(entityIdentifier, "entityIdentifier");
      initBits &= ~INIT_BIT_ENTITY_IDENTIFIER;
      return this;
    }

    /**
     * Initializes the value for the {@link Entity#hasNestedEntities() hasNestedEntities} attribute.
     * @param hasNestedEntities The value for hasNestedEntities 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder hasNestedEntities(boolean hasNestedEntities) {
      this.hasNestedEntities = hasNestedEntities;
      initBits &= ~INIT_BIT_HAS_NESTED_ENTITIES;
      return this;
    }

    /**
     * Initializes the value for the {@link Entity#label() label} attribute.
     * @param label The value for label (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder label(@Nullable String label) {
      this.label = label;
      return this;
    }

    /**
     * Initializes the value for the {@link Entity#description() description} attribute.
     * @param description The value for description (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder description(@Nullable String description) {
      this.description = description;
      return this;
    }

    /**
     * Builds a new {@link ImmutableEntity ImmutableEntity}.
     * @return An immutable instance of Entity
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEntity build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEntity(entityIdentifier, hasNestedEntities, label, description);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ENTITY_IDENTIFIER) != 0) attributes.add("entityIdentifier");
      if ((initBits & INIT_BIT_HAS_NESTED_ENTITIES) != 0) attributes.add("hasNestedEntities");
      return "Cannot build Entity, some of required attributes are not set " + attributes;
    }
  }
}
