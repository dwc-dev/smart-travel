<template>
  <div class="fs-book-card-container">
    <div class="fs-book-card-image">
      <img
        v-if="props.detail.imageUrl"
        :src="props.detail.imageUrl"
        :alt="props.detail.title"
      />
    </div>
    <div class="fs-book-card-footer">
      <div class="title">{{ props.detail.title }}</div>
      <div class="address">
        <div class="address-info">
          <div class="avatar">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="100%"
              height="100%"
              viewBox="0 0 24 24"
            >
              <path
                fill="currentColor"
                d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7m0 9.5a2.5 2.5 0 0 1 0-5a2.5 2.5 0 0 1 0 5"
              />
            </svg>
          </div>
          <span class="name">{{ props.detail.address }}</span>
        </div>
        <!-- <div class="like">100</div> -->
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
interface ICardDetail {
  bgColor: string;
  title: string;
  address: string;
  imageUrl?: string;
  imageHeight: number;
  [key: string]: any;
}
const props = defineProps<{
  detail: ICardDetail;
}>();
</script>

<style scoped lang="scss">
.fs-book-card {
  &-container {
    width: 100%;
    height: 100%;
    background-color: #fff;
  }
  &-image {
    position: relative;
    width: 100%;
    height: v-bind('`${props.detail.imageHeight}px`');
    overflow: hidden;
    border: 1px solid #eee;
    border-radius: 20px;
    background-color: v-bind('props.detail.bgColor');

    &:after {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      transition: background-color 0.2s;
      background-color: transparent;
      -webkit-transform: translateZ(0);
    }

    &:hover:after {
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.25);
      -webkit-transform: translateZ(0);
    }
  }
  &-footer {
    padding: 12px;
    font-size: 14px;
    .title {
      margin-bottom: 8px;
      word-break: break-all;
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 2;
      overflow: hidden;
      color: rgba(51, 51, 51, 0.8);
    }
    .address {
      font-size: 13px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      gap: 5px;
      .address-info {
        flex: 1;
        display: flex;
        align-items: center;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        .avatar {
          margin-right: 6px;
          width: 20px;
          height: 20px;
          color: rgba(51, 51, 51, 0.8);
        }
        .name {
          width: 80%;
          overflow: hidden;
          text-overflow: ellipsis;
          white-space: nowrap;
          color: rgba(51, 51, 51, 0.8);
        }
      }
    }
  }
}
</style>
