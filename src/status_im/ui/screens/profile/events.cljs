(ns status-im.ui.screens.profile.events
  (:require [re-frame.core :as re-frame]
            [status-im.ui.screens.profile.navigation]
            [status-im.utils.handlers :as handlers]
            [status-im.ui.screens.profile.models :as models]))

(re-frame/reg-fx
 :open-image-picker
  ;; the image picker is only used here for now, this effect can be use in other scenarios as well
 (fn [callback-event]
   (models/open-image-picker! callback-event)))

(handlers/register-handler-fx
 :profile/send-transaction
 (fn [cofx [_ chat-id]]
   (models/send-transaction-from-profile chat-id cofx)))

(handlers/register-handler-fx
 :my-profile/update-name
 (fn [cofx [_ name]]
   (models/update-name name cofx)))

(handlers/register-handler-fx
 :my-profile/update-picture
 (fn [cofx [this-event base64-image]]
   (models/update-picture this-event base64-image cofx)))

(handlers/register-handler-fx
 :my-profile/start-editing-profile
 (fn [cofx _]
   (models/start-editing-profile cofx)))

(handlers/register-handler-fx
 :my-profile/save-profile
 (fn [cofx _]
   (models/save-profile cofx)))

(handlers/register-handler-fx
 :group-chat-profile/start-editing
 (fn [cofx _]
   (models/start-editing-group-chat-profile cofx)))

(handlers/register-handler-fx
 :group-chat-profile/save-profile
 (fn [cofx _]
   (models/save-group-chat-profile cofx)))

(handlers/register-handler-fx
 :my-profile/enter-two-random-words
 (fn [cofx _]
   (models/enter-two-random-words cofx)))

(handlers/register-handler-fx
 :my-profile/set-step
 (fn [cofx [_ step]]
   (models/set-step step cofx)))

(handlers/register-handler-fx
 :my-profile/finish
 (fn [cofx _]
   (models/finish cofx)))

(re-frame/reg-fx
 :copy-to-clipboard
 (fn [value]
   (models/copy-to-clipboard! value)))

(handlers/register-handler-fx
 :copy-to-clipboard
 (fn [_ [_ value]]
   {:copy-to-clipboard value}))

(re-frame/reg-fx
 :show-tooltip
 models/show-tooltip!)

(handlers/register-handler-fx
 :show-tooltip
 (fn [_ [_ tooltip-id]]
   {:show-tooltip tooltip-id}))
