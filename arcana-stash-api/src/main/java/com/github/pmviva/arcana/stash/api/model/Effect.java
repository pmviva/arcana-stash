/*
 * Copyright (c) 2025 Pablo Martin Viva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.pmviva.arcana.stash.api.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "effects")
public class Effect extends AuditableEntity {
    /**
     * Stores the user of the effect
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Stores the name of the effect
     */
    private String name;

    /**
     * Stores the duration of the effect in minutes
     */
    private Integer duration;

    /**
     * Stores the setup of the effect
     */
    private String setup;

    /**
     * Stores the explanation of the effect
     */
    private String explanation;

    /**
     * Stores the difficulty of the effect
     */
    private EffectDifficulty difficulty;

    /**
     * Stores the scripts of the effect
     */
    @ManyToMany
    @JoinTable(name = "effect_script_usages")
    private Set<Script> scripts = Set.of();

    /**
     * Stores the effect prop usages of the effect
     */
    @OneToMany(mappedBy = "effect", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EffectPropUsage> props = Set.of();

    /**
     * Stores the routines of the effect
     */
    @ManyToMany
    @JoinTable(name = "routine_effect_usages")
    private Set<Routine> routines = Set.of();

    /**
     * Stores the practice sessions of the effect
     */
    @OneToMany(mappedBy = "effect")
    private Set<EffectPracticeSession> practiceSessions = Set.of();

    /**
     * Stores the media effect references of the effect
     */
    @OneToMany(mappedBy = "effect", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MediaEffectReference> media = Set.of();

    /**
     * Stores the categories of the effect
     */
    @ManyToMany
    @JoinTable(name = "effects_category_assignments")
    private Set<Category> categories = Set.of();

    /**
     * Stores the categories of the effect
     */
    @ManyToMany
    @JoinTable(name = "effects_tag_assignments")
    private Set<Tag> tags = Set.of();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public EffectDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(EffectDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Script> getScripts() {
        return scripts;
    }

    public void setScripts(Set<Script> scripts) {
        this.scripts = scripts;
    }

    public Set<EffectPropUsage> getProps() {
        return props;
    }

    public void setProps(Set<EffectPropUsage> props) {
        this.props = props;
    }

    public Set<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(Set<Routine> routines) {
        this.routines = routines;
    }

    public Set<EffectPracticeSession> getPracticeSessions() {
        return practiceSessions;
    }

    public void setPracticeSessions(Set<EffectPracticeSession> practiceSessions) {
        this.practiceSessions = practiceSessions;
    }

    public Set<MediaEffectReference> getMedia() {
        return media;
    }

    public void setMedia(Set<MediaEffectReference> media) {
        this.media = media;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
